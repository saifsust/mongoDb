package org.javawebdevelopment.controller;

import org.javawebdevelopment.models.User;
import org.javawebdevelopment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("registrationUser")
public class RegistrationUser {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUpPage() {

		return this.direct();
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user) {
		// System.out.println("Hello Reg");
		User user1 = null;
		user1 = userRepository.findByEmail(user.getEmail());
		if (user1 == null) {
			userRepository.insert(user);
		} else {
			return this.redirect();
		}
		// System.out.println(user.getName());

		return "index";
	}

	private String direct() {
		return "sign-up";
	}

	private String redirect() {
		return "redirect:/sign-up";
	}

}
