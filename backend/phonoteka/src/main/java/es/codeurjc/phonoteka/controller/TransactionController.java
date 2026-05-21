package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TransactionController {

    @GetMapping("/transaction/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/transaction/leave-rating")
    public String leaveRating() {
        return "leave-rating";
    }

    @GetMapping("/transaction/success")
    public String success() {
        return "success";
    }
}