package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VinylController {

    @GetMapping("/vinyl/add")
    public String addVinyl() {
        return "add-vinyl";
    }

    @GetMapping("/vinyl/search")
    public String search() {
        return "search-results";
    }

    @GetMapping("/vinyl")
    public String vinyl(@RequestParam boolean logged) {
        if (!logged) {
            return "vinyl";
        } else {
            return "vinyl-logged";
        }
    }
   
}