package com.mario.spring.form_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mario.spring.form_register.pessoa.Person;
import com.mario.spring.form_register.pessoa.PersonRepository;
import com.mario.spring.form_register.pessoa.RequestPerson;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository repository;

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
		List<Person> people = repository.findAll();

		model.addAttribute("pessoas", people);
		return "list_people";
	}

	@GetMapping(path = "/pessoa/cadastro")
	public String addPerson() {
		return "open_form";
	}

	@PostMapping(value = "/pessoa/salvar")
	public String savePerson(@Validated RequestPerson data) {
		Person p = Person.of(data);
		// System.out.println("Nome: " + p.getName());
		// System.out.println("Número: " + p.getAdr_numb());
		repository.saveAndFlush(p);

		return "redirect:/pessoa";
	}
	// https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html
}
