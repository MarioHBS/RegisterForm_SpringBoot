package com.mario.registration_form.form_registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    
    @GetMapping(path = "/")
    public String getIndex() {
        return "index";
    }
}
