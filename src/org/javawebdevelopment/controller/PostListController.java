package org.javawebdevelopment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.javawebdevelopment.algorithms.DbModelProcessor;
import org.javawebdevelopment.models.Post;
import org.javawebdevelopment.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("postListController")
public class PostListController {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private MongoOperations mongoOperations;

	@RequestMapping(value = "/post-list", method = RequestMethod.GET)
	public ModelAndView showPostList(HttpServletRequest httpServletRequest) {

		System.out.println("Post List Viewer " + httpServletRequest);

		ModelAndView model = new ModelAndView("admin/post-list");
		// List<Post> postList = postRepository.findAll();
		try {
			List<Post> postList = DbModelProcessor.getAuthorAllPost("5a67193660704e7636809f2b", postRepository);
			model.addObject("list", postList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(postList);

		return model;
	}

	@GetMapping("/post-list/{action}/{id}")
	public ModelAndView actionPost(@PathVariable("action") String action, @PathVariable("id") String id,
			RedirectAttributes attr) {

		switch (action) {
		case "e":
			System.out.println(action);
			//Post post = postRepository.getPostById(id);
			//System.out.println(postRepository.getPostById(id).getTitle());
			//System.out.println("return Controller " + post);
			//attr.addFlashAttribute("post", post);
			model = new ModelAndView(this.redirect("post"));
			return model;
		case "d":

			// System.out.println(action);
			try {
				DbModelProcessor.deletePostById(id, postRepository);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// mongoOperations.remove(query, Post.class);
			break;
		default:
			System.out.println("someThing Wrong " + action);
			break;
		}
		model = new ModelAndView(this.redirect(own));
		return model;
	}

	private String direct() {
		return "admin/post-list";
	}

	private String redirect(String page) {
		return "redirect:/" + page;
	}

	private final String own = "post-list";
	private ModelAndView model;
}
