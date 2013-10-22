package de.tilman.nodebucket.domain;

public class Page extends Node {
	
	private String content;
	
	public Page(String title) {
		super(title, MimeType.TEXT);
	}

	@Override
	public Object getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
