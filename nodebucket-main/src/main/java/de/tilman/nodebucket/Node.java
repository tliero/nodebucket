package de.tilman.nodebucket;

import java.util.HashSet;
import java.util.Set;

public abstract class Node {

	public enum Visibility { PUBLIC, PRIVATE, GROUP };
	
	private String title;
	private byte[] content;
	private String mimeType;
	private Visibility visibility;
	private Set<String> tags = new HashSet<String>();
	private Set<Node> backlinks = new HashSet<Node>();
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

}
