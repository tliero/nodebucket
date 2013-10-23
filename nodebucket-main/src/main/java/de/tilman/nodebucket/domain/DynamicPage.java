package de.tilman.nodebucket.domain;

import javax.persistence.Entity;

@Entity
public class DynamicPage extends Node {
	
	public DynamicPage(String title) {
		super(title, MimeType.TEXT);
	}

	@Override
	public Object getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
