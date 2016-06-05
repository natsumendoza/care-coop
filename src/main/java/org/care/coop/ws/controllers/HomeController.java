package org.care.coop.ws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class HomeController {

	@RequestMapping("/care-coop")
	public String index() {
		return "/index/index";
	}
	
}
