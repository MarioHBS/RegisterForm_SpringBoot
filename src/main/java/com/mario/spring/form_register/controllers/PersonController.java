package com.mario.spring.form_register.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

	@GetMapping(path = "/")
	public String openApp() {
		return "index";
	}

	@GetMapping(value = "/second")
	public String openSecond(@RequestParam("p") String name, Model model) {
		model.addAttribute("nome", name);
		return "second";
	}

	@GetMapping(path = "/pessoa/cadastro")
	public String addPerson() {
		return "open_form";
	}
	// https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html
}
