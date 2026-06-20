package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.codeurjc.phonoteka.service.TransactionService;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transaction/checkout", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkout(Model model) {
        log.info("Checkout page requested");
    model.addAttribute("pageTitle", "Checkout - La Phonoteka");
    model.addAttribute("styles", List.of("/css/style.css", "/css/checkout.css"));
    model.addAttribute("homeHref", "/?logged=true");
    model.addAttribute("showSearchBar", false);
    model.addAttribute("showCartButton", false);
    model.addAttribute("showProfileLink", false);
    model.addAttribute("showAuthButtons", false);
    model.addAttribute("showCartDrawer", false);
    model.addAttribute("orderItems", transactionService.getOrderItems());
    model.addAttribute("subtotal", transactionService.getSubtotal());
    model.addAttribute("shipping", transactionService.getShipping());
    model.addAttribute("total", transactionService.getTotal());

        return "checkout";
    }

    @RequestMapping(value = "/transaction/leave-rating", method = {RequestMethod.GET, RequestMethod.POST})
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