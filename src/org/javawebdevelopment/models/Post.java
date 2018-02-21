package org.javawebdevelopment.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post {

	@Id
	private ObjectId id;
	private String title;
	private String description;
	private String date;
	private String link;
	private ObjectId authorId;

	public Post() {

	}



	public Post(String title, String description, String date, String link, ObjectId authorId) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.link = link;
		this.authorId = authorId;
	}



	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}



	public ObjectId getId() {
		return id;
	}



	public void setId(ObjectId id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public ObjectId getAuthorId() {
		return authorId;
	}



	public void setAuthorId(ObjectId authorId) {
		this.authorId = authorId;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", link="
				+ link + ", authorId=" + authorId + "]";
	}

}
