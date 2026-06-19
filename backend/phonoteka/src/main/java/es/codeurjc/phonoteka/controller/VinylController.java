package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;

@Controller
public class VinylController {

    @GetMapping("/vinyl/add")
    public String addVinyl() {
        log.info("Add vinyl page requested");
        return "add-vinyl";
    }

    @GetMapping("/vinyl/search")
    public String search() {
        log.info("Search results page requested");
        return "search-results";
    }

    @GetMapping("/vinyl")
    public String vinyl(@RequestParam boolean logged) {
        log.info("Vinyl page requested");
        if (!logged) {
            return "vinyl";
        } else {
            return "vinyl-logged";
        }
    }
   
}