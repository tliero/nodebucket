package de.tilman.nodebucket.domain;

import java.util.HashSet;
import java.util.Set;

public class Group {

	private long id;
	private String name;
	private User groupAdmin;
	private Set<User> users = new HashSet<User>();

	
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getGroupAdmin() {
		return groupAdmin;
	}

	public void setGroupAdmin(User groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUser(User user) {
		users.remove(user);
	}
}
