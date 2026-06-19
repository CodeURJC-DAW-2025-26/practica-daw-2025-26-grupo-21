package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class SessionController {
    
    @RequestMapping("/session/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        log.info("Login page requested");
        model.addAttribute("email", email);
        model.addAttribute("password", password);

        return "login";
    }

    @GetMapping("/session/register")
    public String register() {
        log.info("Register page requested");
        return "register";
    }

}
