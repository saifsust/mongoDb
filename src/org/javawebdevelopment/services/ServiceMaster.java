package org.javawebdevelopment.services;

import java.util.ArrayList;
import java.util.List;

import org.javawebdevelopment.models.Post;
import org.javawebdevelopment.models.PostViewer;
import org.javawebdevelopment.models.User;
import org.javawebdevelopment.repositories.PostRepository;
import org.javawebdevelopment.repositories.UserRepository;

public class ServiceMaster {

	public static List<PostViewer> viewer(PostRepository postRepository, UserRepository userRepository) {

		List<PostViewer> viewerList = new ArrayList<>();
		List<Post> postList = postRepository.findAll();
		viewerList.clear();
		for (Post post : postList) {
			User user = userRepository.findById(post.getAuthorId());
			viewerList.add(new PostViewer(post, user));
		}
		/*
		 * for (PostViewer v : viewerList) { System.out.println(v); }
		 */
		return viewerList;
	}

}
