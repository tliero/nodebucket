package de.tilman.nodebucket.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
    @Id
	private String name;
	private String email;
	private String passwordHash;
	private boolean superuser;
	
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

}
