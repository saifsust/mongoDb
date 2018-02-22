package org.javawebdevelopment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.javawebdevelopment.algorithms.StringProcessor;
import org.javawebdevelopment.models.Post;
import org.javawebdevelopment.models.PostViewer;
import org.javawebdevelopment.models.User;
import org.javawebdevelopment.repositories.PostRepository;
import org.javawebdevelopment.repositories.UserRepository;
import org.javawebdevelopment.services.ServiceMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringProperties;
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
		System.out.println(StringProcessor.getCurrentTime());
		List<PostViewer> viewers = ServiceMaster.viewer(postRepository, userRepository);
		// System.out.println("Home");
		// System.out.println(session.getAttribute("user"));
		// System.out.println(viewers);
		model.addObject("user", user);
		model.addObject("views", viewers);

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
			post.setDate(StringProcessor.getCurrentTime());
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
