package de.tilman.nodebucket;

public class Page extends Node {
	
	private String content;
	
	public Page(String title) {
		super(title, MimeType.TEXT);
	}

	@Override
	public Object getContent() {
		return content;
	}

	@Override
	public void setContent(byte[] content) {
		this.content = new String(content);
	}

}
