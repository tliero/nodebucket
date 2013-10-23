package de.tilman.nodebucket.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
    @Id
	private String name;
	private String email;
	private String passwordHash;
	private boolean superuser;
	
	
	protected User() {}
	
	public User(String name, String email, String passwordHash, boolean superuser) {
		super();
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.superuser = superuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isSuperuser() {
		return superuser;
	}

	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}
	
	@Override
	public String toString() {
		return String.format("User[name='%s', email='%s', superuser=%b]", name, email, superuser);
	}

}
