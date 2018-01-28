package org.javawebdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("followerController")
public class FollowerController {

	@RequestMapping(value = "/follower", method = RequestMethod.GET)
	public String showFollower() {
		System.out.println("follower controller");
		return direct();
	}

	private String direct() {
		return "admin/follower";
	}

}
