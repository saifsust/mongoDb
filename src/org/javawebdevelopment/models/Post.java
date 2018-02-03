package org.javawebdevelopment.models;

import java.util.Arrays;

import org.javawebdevelopment.algorithms.StringProcessor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class Post {

	@Id
	private String id;
	private String title;
	private String description;
	private String date;
	private String[] links;
	private String authorId;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String title, String description, String date, String[] links, String authorId) {
		super();
		this.id = id;
		this.title = StringProcessor.descriptionProcess(title);
		this.description = StringProcessor.descriptionProcess(description);
		this.date = date;
		this.links = links;
		this.authorId = authorId;
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
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", links="
				+ Arrays.toString(links) + ", authorId=" + authorId + "]";
	}

}
