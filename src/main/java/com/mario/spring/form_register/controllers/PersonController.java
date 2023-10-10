package com.mario.spring.form_register.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.spring.form_register.pessoa.Person;
import com.mario.spring.form_register.pessoa.RequestPerson;

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

	/**
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/pessoa")
	public String getAllPeople(Model model) {
		List<Person> people = new ArrayList<Person>();
		Person p = new Person("aacascac", "Manoel", "01/01/2000", "9898474754", "email@gmail.com", "65110000", "", 1,
				"bairro", "São Luís", "MA");

		people.add(p);
		model.addAttribute("pessoas", people);
		return "list_people";
	}

	@GetMapping(path = "/pessoa/cadastro")
	public String addPerson() {
		return "open_form";
	}

	@PostMapping(value = "/pessoa/salvar")
	public String savePerson(@Validated RequestPerson data) {
		System.out.println("Nome: " + data.name());
		return "redirect:/pessoa";
	}
	// https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html
}
