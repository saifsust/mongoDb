package org.javawebdevelopment.models;

import org.javawebdevelopment.algorithms.StringProcessor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post {

	@Id
	private String id;
	private String title;
	private String description;
	private String date;
	private String fileLink;
	private String authorId;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String authorId, String title, String description, String date, String fileLink) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.title = title;
		this.description = StringProcessor.descriptionProcess(description);
		this.date = date;
		this.fileLink = fileLink;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		this.description = StringProcessor.descriptionProcess(description);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", fileLink="
				+ fileLink + ", authorId=" + authorId + "]";
	}

}
