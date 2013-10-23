package de.tilman.nodebucket.domain;

import javax.persistence.Entity;

@Entity
public class File extends Node {
	
	private byte[] content;
	
	public File(String title) {
		super(title, MimeType.FILE);
	}

	@Override
	public Object getContent() {
		return content;
	}
	
	public void setContent(byte[] content) {
		this.content = content;
	}

}
