package com.mario.spring.form_register;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FormRegisterApplication {

    public static void main(String[] args) {
//		var env = System.getenv();
//		System.out.println("user_db = " + env.get("MYSQL_DB_USER"));
        // https://stackoverflow.com/a/47354290/3443949
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(FormRegisterApplication.class)
                .environment(new StandardEnvironment() {
                    @Override
                    public Map<String, Object> getSystemEnvironment() {
                        return new HashMap<>();
                    }

                    @Override
                    public Map<String, Object> getSystemProperties() {
                        return new HashMap<>();
                    }
                });
        applicationBuilder.run(args);
    }

    @Component
    public static class Runner implements ApplicationRunner {
        @Value("${hello:Hello from code}")
        String hello;
        @Value("${spring.datasource.url}")
        String banco;
        @Value("${spring.datasource.username}")
        String user;

        public void run(ApplicationArguments args) throws Exception {
            System.out.println("Propriedade hello: " + hello);
            System.out.println("Caminho do BD: " + banco);
            System.out.println("Usuário do BD: " + user);
        }
    }
}
