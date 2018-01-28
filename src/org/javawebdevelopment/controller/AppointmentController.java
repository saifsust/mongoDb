package org.javawebdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("appointmentController")
public class AppointmentController {

	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String showAppointList() {
		System.out.println("Show Appointment Controller");
		return direct();
	}

	private String direct() {
		return "admin/appointment";
	}

	private String redirect() {
		return "appointment";
	}
}
