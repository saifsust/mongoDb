package org.javawebdevelopment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("googleMapController")
public class GoogleMapController {
	private ModelAndView model;

	@RequestMapping(value = "/google-map", method = RequestMethod.GET)
	public ModelAndView viewLocation() {

		System.out.println("Geo Location :  ");
		model = new ModelAndView(this.direct());
		System.out.println("Google Map");
		return model;
	}

	@RequestMapping(value = "/google-map", method = RequestMethod.POST)
	public ModelAndView getLocation(@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude) {

		System.out.println("Geo Location : Long= " + longitude + "  lati = " + latitude);
		model = new ModelAndView(this.direct());
		System.out.println("Google Map");
		return model;
	}

	private String direct() {
		return "admin/google-map";
	}

	private String redirect() {
		return "redirect:/google-map";
	}

}
