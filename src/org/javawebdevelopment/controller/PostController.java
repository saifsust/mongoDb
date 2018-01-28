package org.javawebdevelopment.controller;

import javax.servlet.http.HttpSession;

import org.javawebdevelopment.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("postController")
public class PostController {

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String showPost() {
		System.out.println("Post Controller");
		return direct();
	}

	@RequestMapping(value = "/uploadPost", method = RequestMethod.POST)
	public String uploadPost(Post post, BindingResult result) {
		if (result.hasErrors())
			return "ERROR";
		System.out.println(post);
		return redirect();
	}

	private String direct() {
		return "admin/post";
	}

	private String redirect() {
		return "redirect:/post";
	}

}
