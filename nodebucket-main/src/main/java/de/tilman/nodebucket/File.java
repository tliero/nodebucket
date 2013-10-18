package de.tilman.nodebucket;

public class File extends Node {
	
	private byte[] content;
	
	public File(String title) {
		super(title, MimeType.FILE);
	}

	@Override
	public Object getContent() {
		return content;
	}

	@Override
	public void setContent(byte[] content) {
		this.content = content;
	}

}
