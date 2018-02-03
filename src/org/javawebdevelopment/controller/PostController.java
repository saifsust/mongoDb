package org.javawebdevelopment.controller;

import javax.servlet.http.HttpServletRequest;

import org.javawebdevelopement.repositories.PostRepository;
import org.javawebdevelopment.algorithms.StringProcessor;
import org.javawebdevelopment.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("postController")
public class PostController {
	private static final String STORE_PATH = "STORE_HOUSE/";
	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private PostRepository postRepository;

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String showPost() {
		System.out.println("Post Controller");
		return direct();
	}

	@RequestMapping(value = "uploadPost", method = RequestMethod.POST)
	public String uploadPost(@RequestParam("fileLinks") MultipartFile[] files, @ModelAttribute("post") Post post,
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
		}
		try {
			String[] links = new String[files.length];
			int index = 0;
			for (MultipartFile file : files) {
				if (!file.getOriginalFilename().isEmpty()) {
					links[index++] = StringProcessor.fileLinkProcessor(file, httpServletRequest);
				}
			}

			post.setLinks(links);
			post.setDate(StringProcessor.getCurrentTime());
			postRepository.insert(post);
			//System.out.println(post);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return redirect();
	}

	private String direct() {
		return "admin/post";
	}

	private String redirect() {
		return "redirect:/post";
	}

}
