package com.carpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class HomeController {

 // Maps the home page for the jsp.

	@RequestMapping(method = RequestMethod.GET)
	public String loadHome(ModelMap model) {
		return "home";
	}

}