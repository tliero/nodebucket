package de.tilman.nodebucket.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//@MappedSuperclass  // kollidiert mit one-to-many-Mapping für Backlinks
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Node {

	public enum Visibility { PUBLIC, PRIVATE, GROUP };
	
	public enum MimeType {
		TEXT ("application/xhtml+xml"),
		FILE ("application/octet-stream"),
		JPEG ("image/jpeg");
		
		private final String mimeType;
		
		private MimeType(String mimeType) {
			this.mimeType = mimeType;
		}
		
		public String getType() {
			return mimeType;
		}
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
    private String title;
    private MimeType mimeType;
 	private Visibility visibility;
	private HashSet<String> tags = new HashSet<String>();
	
	@OneToMany
	@ElementCollection
	@JoinColumn(referencedColumnName="id", name="backlink")
	private Set<Node> backlinks = new HashSet<Node>();
	
	
	protected Node() {}
	
	public Node(String title, MimeType mimeType) {
		this.id = 0; // TODO create unique ID
		
		this.title = title; // TODO check if Node with this title already exists
		this.mimeType = mimeType;
	}
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MimeType getMimeType() {
		return mimeType;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	
	public void addTag(String tag) {
		tags.add(tag);
	}
	
	public void removeTag(String tag) {
		tags.remove(tag);
	}
	
	public void addBacklink(Node node) {
		backlinks.add(node);
	}
	
	public void removeBacklink(Node node) {
		backlinks.remove(node);
	}
	
	
	@Override
	public String toString() {
		return String.format("Node[id=%d, title='%s']", id, title);
	}

	public abstract Object getContent();

}
