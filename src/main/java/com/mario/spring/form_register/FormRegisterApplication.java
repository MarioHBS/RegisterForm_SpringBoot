package com.mario.spring.form_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormRegisterApplication {

	public static void main(String[] args) {
//		var env = System.getenv();
//		System.out.println("user_db = " + env.get("SPRING_DATASOURCE_USERNAME"));
//		System.out.println("user_psw = " + env.get("SPRING_DATASOURCE_PASSWORD"));
		SpringApplication.run(FormRegisterApplication.class, args);
	}

}
