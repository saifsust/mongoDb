package org.javawebdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("expectedAppointmentController")
public class ExpectedAppointmentController {

	@RequestMapping(value = "/expected-appointment", method = RequestMethod.GET)
	public String ShowExpectedAppointmentList() {
		System.out.println("Expected Controller");
		return direct();
	}

	private String direct() {
		return "admin/expected-appointment";
	}

}
