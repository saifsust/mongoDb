package org.javawebdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("postListController")
public class PostListController {

	@RequestMapping(value = "/post-list", method = RequestMethod.GET)
	public String showPostList() {
		System.out.println("Post List Controller");
		return direct();
	}

	private String direct() {
		return "admin/post-list";
	}
}
