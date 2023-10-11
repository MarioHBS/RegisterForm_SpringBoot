package com.mario.spring.form_register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mario.spring.form_register.pessoa.Person;
import com.mario.spring.form_register.pessoa.PersonRepository;

@RestController
public class ConfigController {
    @Autowired
    private PersonRepository repository;

    @GetMapping(path = "/get_all_people")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> findAll = repository.findAll();
        if (findAll.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(findAll);
        }
    }
}
