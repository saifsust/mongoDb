package org.javawebdevelopment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javawebdevelopment.algorithms.EncryptionUtil;
import org.javawebdevelopment.models.SignIn;
import org.javawebdevelopment.models.User;
import org.javawebdevelopment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("userLogInController")
public class UserLogInController {

	/*** properties ****/
	private boolean isMatch = false;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goSignIn(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello World");
		return this.direct();
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String signIn(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello World");
		return this.direct();
	}

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(@ModelAttribute("signIn") SignIn signIn, HttpServletRequest request,
			HttpServletResponse response) {
		User user = userRepository.findByEmail(signIn.getUserName());
		if (user != null)
			isMatch = EncryptionUtil.match(signIn.getPassword(), user.getPassword());

		if (isMatch) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return this.home();
		} else {
			return this.redirect();
		}

	}

	private String home() {
		return "redirect:/home";
	}

	private String direct() {
		return "sign-in";
	}

	private String redirect() {
		return "redirect:/sign-in";
	}

}
