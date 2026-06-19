package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam boolean logged) {
        log.info("Home page requested");
        if (!logged) {
            return "index";
        } else {
            return "index-logged";
        }
    }
}
