package org.javawebdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("chatController")
public class ChatController {

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String showChatList() {

		System.out.println("Chat Controller");
		return direct();
	}

	private String direct() {
		return "admin/chat";
	}

}
