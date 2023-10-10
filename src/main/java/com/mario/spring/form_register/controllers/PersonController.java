package com.mario.spring.form_register.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

  @GetMapping(path = "/")
  public String openApp() {
    return "index";
  }

  @GetMapping(path = "/second")
  public String openSecond() {
    return "second";
  }

}
