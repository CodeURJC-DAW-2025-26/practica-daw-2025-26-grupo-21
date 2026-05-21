package es.codeurjc.phonoteka.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SessionController {
    
    @GetMapping("/session/login")
    public String login() {
        return "login";
    }

    @GetMapping("/session/register")
    public String register() {
        return "register";
    }

}
