package br.com.eagrobusiness.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExemploController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/dados-acesso")
    public String relatorioAcessos() {
        return "dados-acesso";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
