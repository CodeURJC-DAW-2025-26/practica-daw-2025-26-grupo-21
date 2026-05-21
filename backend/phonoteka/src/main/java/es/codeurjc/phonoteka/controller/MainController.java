package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam boolean logged) {
        if (!logged) {
            return "index";
        } else {
            return "index-logged";
        }
    }
}
