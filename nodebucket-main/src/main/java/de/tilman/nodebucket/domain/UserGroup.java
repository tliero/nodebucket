package de.tilman.nodebucket.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserGroup implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToOne
	@JoinColumn(name="adminName")
	private User groupAdmin;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection
	@JoinColumn(referencedColumnName="name", name="userName")
	private Set<User> users = new HashSet<User>();
//	@CollectionTable(joinColumns={@JoinColumn(referencedColumnName="name", name="userName")})

	
	protected UserGroup() {}
	
	public UserGroup(String name, User groupAdmin) {
		super();
		this.name = name;
		this.groupAdmin = groupAdmin;
	}
	
	
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
	
	@Override
	public String toString() {
//		return String.format("User[name='%s', admin='%s']", name, groupAdmin.getName());
		
		StringBuffer userList = new StringBuffer();
		for (User user : users) {
			userList.append(user.getName());
			userList.append(", ");
		}
		
		return "User[name='" + name + "', admin='" + groupAdmin.getName() + "', members={" + userList + "}]";
	}
}
