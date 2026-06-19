package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;

@Controller
public class ErrorController {

    @GetMapping("/error/404")
    public String notFoundError() {
        log.info("404 error page requested");
        return "404";
    }
}