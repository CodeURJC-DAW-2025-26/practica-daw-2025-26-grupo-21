package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;
import static es.codeurjc.phonoteka.utils.TemplateData.checkoutItem;


@Controller
public class TransactionController {

    @GetMapping("/transaction/checkout")
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
    model.addAttribute("orderItems", List.of(
        checkoutItem("Nevermind", "Nirvana", "1", "29,90 €",
            "https://picsum.photos/seed/order1/120/120"),
        checkoutItem("Abbey Road", "The Beatles", "1", "28,50 €",
            "https://picsum.photos/seed/order2/120/120"),
        checkoutItem("Random Access Memories", "Daft Punk", "1", "31,20 €",
            "https://picsum.photos/seed/order3/120/120")));
    model.addAttribute("subtotal", "89,60 €");
    model.addAttribute("shipping", "4,50 €");
    model.addAttribute("total", "94,10 €");

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