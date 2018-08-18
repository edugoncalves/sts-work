package br.com.eagrobusiness.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WebApplication {

	@Autowired
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        
    }

}
