package de.tilman.nodebucket;

import java.util.HashSet;
import java.util.Set;

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
	
	private String title;
	private MimeType mimeType;
	private Visibility visibility;
	private Set<String> tags = new HashSet<String>();
	private Set<Node> backlinks = new HashSet<Node>();
	
	
	public Node(String title, MimeType mimeType) {
		this.title = title; // TODO check if Node with this title already exists
		this.mimeType = mimeType;
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
	
	public abstract Object getContent();

	public abstract void setContent(byte[] content);

}
