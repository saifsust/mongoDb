package org.javawebdevelopment.models;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.javawebdevelopment.algorithms.EncryptionUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String name;
	private String email;
	private String dept;
	private String occupation;
	private String session;
	private String institute;
	private String password;
	private ObjectId[] posts;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String dept, String occupation, String session, String institute,
			String password, ObjectId[] posts) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.occupation = occupation;
		this.session = session;
		this.institute = institute;
		this.password = password;
		this.posts = posts;
	}

	public User(String name, String email, String dept, String occupation, String session, String institute,
			String password) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.occupation = occupation;
		this.session = session;
		this.institute = institute;
		this.password = password;
	}

	public User(String id, String name, String email, String dept, String occupation, String session, String institute,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.occupation = occupation;
		this.session = session;
		this.institute = institute;
		this.password = password;
	}

	public ObjectId[] getPosts() {
		return posts;
	}

	
	
	public void setPosts(ObjectId[] posts) {
		this.posts = posts;
	}

	public void setPost(ObjectId postId) {
		Object[] post = new ObjectId[this.posts.length + 1];
		for (int i = 0; i < this.posts.length; i++) {
			post[i] = this.posts[i];
		}
		post[this.posts.length] = postId;
		this.posts = (ObjectId[]) post;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = EncryptionUtil.encript(password);
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", dept=" + dept + ", occupation="
				+ occupation + ", session=" + session + ", institute=" + institute + ", password=" + password
				+ ", posts=" + Arrays.toString(posts) + "]";
	}

}
