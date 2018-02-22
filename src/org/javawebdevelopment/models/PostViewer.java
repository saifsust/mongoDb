package org.javawebdevelopment.models;

public class PostViewer {

	private Post post;
	private User user;

	public PostViewer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostViewer(Post post, User user) {
		super();
		this.post = post;
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostViewer [post=" + post + ", user=" + user + "]";
	}

}
