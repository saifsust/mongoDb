package org.javawebdevelopment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
	@Id
	private String id;
	private String Name;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String name) {
		super();
		this.id = id;
		Name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

}
