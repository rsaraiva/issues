package com.rsaraiva.labs.issues.model;

import java.io.Serializable;

import javax.persistence.Entity;

import com.rsaraiva.labs.issues.core.CommonEntity;

@Entity
public class User extends CommonEntity implements Serializable {

	private String login;
	
	@Deprecated //Hibernate
	User() {}
	
	public User(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	private static final long serialVersionUID = 7275615675493879661L;
}
