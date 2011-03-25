package com.jverrecchia.template.shared;

import javax.persistence.Id;

public class User {

	@Id Long id;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
