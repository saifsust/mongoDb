package org.javawebdevelopment.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("logInController")
public class AccountController {

	@GetMapping("/login")
	public String showLogInPage(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Hello Log in " + auth.getName());

		return "login";
	}

}
