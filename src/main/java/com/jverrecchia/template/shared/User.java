package com.jverrecchia.template.shared;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class User implements Serializable{

	@Id Long id;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
