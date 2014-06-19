package de.tilman.nodebucket.views;

import io.dropwizard.views.View;
import de.tilman.nodebucket.representations.Page;

public class PageView extends View {
	private final Page page;

	public PageView(Page page) {
		super("/views/contact.mustache");
		this.page = page;
	}

	public Page getPage() {
		return page;
	}
}