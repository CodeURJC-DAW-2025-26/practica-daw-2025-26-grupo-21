package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class TransactionController {

    @GetMapping("/transaction/checkout")
    public String checkout() {
        log.info("Checkout page requested");
        return "checkout";
    }

    @GetMapping("/transaction/leave-rating")
    public String leaveRating() {
        log.info("Leave rating page requested");
        return "leave-rating";
    }

    @GetMapping("/transaction/success")
    public String success() {
        log.info("Success page requested");
        return "success";
    }
}