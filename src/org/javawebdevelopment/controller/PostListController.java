package org.javawebdevelopment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.javawebdevelopement.repositories.PostRepository;
import org.javawebdevelopment.algorithms.DbModelProcessor;
import org.javawebdevelopment.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("postListController")
public class PostListController {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private MongoOperations mongoOperations;

	@RequestMapping(value = "/post-list", method = RequestMethod.GET)
	public ModelAndView showPostList(HttpServletRequest httpServletRequest) {
         
		System.out.println("Post List Viewer "+httpServletRequest);

		ModelAndView model = new ModelAndView("admin/post-list");
		// List<Post> postList = postRepository.findAll();
		try {
			List<Post> postList = DbModelProcessor.getAuthorAllPost("123523523", postRepository);
			model.addObject("list", postList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(postList);

		return model;
	}

	@GetMapping("/post-list/{action}/{id}")
	public String actionPost(@PathVariable("action") String action, @PathVariable("id") String id) {
		Query query = new Query(Criteria.where("id").is(id));
		switch (action) {
		case "e":
			System.out.println(action);
			Post post = mongoOperations.findOne(query, Post.class);
			System.out.println(post.getLinks()[0]);

			break;
		case "d":
			// System.out.println(action);
			mongoOperations.remove(query, Post.class);
			break;
		default:
			System.out.println("someThing Wrong " + action);
			break;
		}
		return this.redirect();
	}

	private String direct() {
		return "admin/post-list";
	}

	private String redirect() {
		return "redirect:/post-list";
	}
}
