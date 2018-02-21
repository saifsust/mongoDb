package org.javawebdevelopment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.javawebdevelopment.algorithms.StringProcessor;
import org.javawebdevelopment.models.Post;
import org.javawebdevelopment.models.User;
import org.javawebdevelopment.repositories.PostRepository;
import org.javawebdevelopment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller("homeController")
public class HomeController {

	/** Properties ***/
	private ModelAndView model;
	private List<Post> posts = new ArrayList<Post>();
	/** Autowire properties ***/
	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		model = new ModelAndView(this.direct());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// System.out.println("Home");
		// System.out.println(session.getAttribute("user"));
		posts.clear();
		for (ObjectId id : user.getPosts()) {
			if (id == null)
				continue;
			Post post = postRepository.getPostById(id);
			posts.add(post);
		}

		model.addObject("name", user.getName());
		model.addObject("occupation", user.getOccupation());
		model.addObject("dept", user.getDept());
		model.addObject("institute", user.getInstitute());
		model.addObject("user", user);
		model.addObject("posts", posts);

		return model;
	}

	@RequestMapping(value = "/appoinment", method = RequestMethod.POST)
	public String getRequest() {
		return this.redirect();
	}

	@RequestMapping(value = "/pUpload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("fileLink") MultipartFile file, @ModelAttribute("post") Post post) {
		model = new ModelAndView(this.redirect());
		try {
			String link = StringProcessor.fileLinkProcessor(file, httpServletRequest);
			post.setLink(link);
			Post save = postRepository.insert(post);
			ObjectId userId = save.getAuthorId();
			ObjectId postId = save.getId();
			User user = userRepository.findById(userId);
			if (user.getPosts() == null)
				user.setPosts(new ObjectId[0]);
			user.setPost(postId);
			userRepository.save(user);
			// System.out.println(userId);

		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return model;
	}

	private String direct() {
		return "index";
	}

	private String redirect() {
		return "redirect:/home";
	}

}
