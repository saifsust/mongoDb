package org.javawebdevelopment.controller;

import org.apache.log4j.Logger;
import org.javawebdevelopment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("nearestKnockerController")
public class NearestKnockerController {

	private Logger log = Logger.getLogger(NearestKnockerController.class);
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String routeHome() {

		if (log.isDebugEnabled()) {
			log.debug("Controller degub is done ");

		}

		log.info("this is an info log entry");
		log.error("this is an error log entry");
		// Users user = new Users("7", "Babu");
		// userRepository.insert(user);
		System.out.println("Nearest Controllers");
		return direct();
	}

	@RequestMapping(value = "/aindex", method = RequestMethod.GET)
	public String redirectHome() {

		System.out.println("index Request");

		return direct();

	}

	private String redirect() {
		return "redirect/index";
	}

	private String direct() {
		return "admin/index";
	}

}
