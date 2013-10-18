package de.tilman.nodebucket.domain;

import java.io.Serializable;

// TODO
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//
//@Entity
//@Table(name="user")
//@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
