package de.tilman.nodebucket.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToOne
	@JoinColumn(name="adminName", referencedColumnName="name")
	private User groupAdmin;
	
	@ElementCollection
	@CollectionTable(joinColumns={@JoinColumn(name="name")})
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
