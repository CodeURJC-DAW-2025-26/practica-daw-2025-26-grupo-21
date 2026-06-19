package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;
import static es.codeurjc.phonoteka.utils.TemplateData.purchaseHistoryItem;
import static es.codeurjc.phonoteka.utils.TemplateData.review;
import static es.codeurjc.phonoteka.utils.TemplateData.stars;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylCard;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylHref;


@Controller
public class UserController {

    @GetMapping("user/profile")
    public String profile(Model model) {
        log.info("User profile page requested");
    model.addAttribute("pageTitle", "Perfil de Usuario - La Phonoteka");
    model.addAttribute("styles", List.of("/css/style.css", "/css/profile.css"));
    model.addAttribute("homeHref", "/?logged=true");
    model.addAttribute("showSearchBar", true);
    model.addAttribute("searchValue", "");
    model.addAttribute("searchPlaceholder", "Buscar en la colección...");
    model.addAttribute("showCartButton", true);
    model.addAttribute("cartCount", 3);
    model.addAttribute("showProfileLink", false);
    model.addAttribute("showAuthButtons", false);
    model.addAttribute("showCartDrawer", true);
    model.addAttribute("profileUsername", "a.morales.2019");
    model.addAttribute("memberSince", "Miembro desde Jul 2025");
    model.addAttribute("salesCount", 12);
    model.addAttribute("ratingsCount", 5);
    model.addAttribute("ratingIcons", stars(4, true));
    model.addAttribute("profileAvatar", "https://i.pravatar.cc/150?u=a.morales.2019");

    model.addAttribute("sellingVinyls", List.of(
        vinylCard("AM", "Arctic Monkeys", "Indie Rock", "33,50 €",
            "https://picsum.photos/seed/profile1/400/400", "Portada de AM", vinylHref(15, true)),
        vinylCard("Currents", "Tame Impala", "Psychedelic Pop", "38,00 €",
            "https://picsum.photos/seed/profile2/400/400", "Portada de Currents", vinylHref(19, true)),
        vinylCard("Is This It", "The Strokes", "Indie Rock", "25,00 €",
            "https://picsum.photos/seed/profile3/400/400", "Portada de Is This It", vinylHref(16, true))));

    model.addAttribute("receivedReviews", List.of(
        review("GrooveGuardian",
            "El vinilo llegó en perfecto estado y muy rápido. ¡Vendedor muy recomendable!",
            stars(4, false)),
        review("WaxWizard", "¡Una joya! Comunicación excelente.", stars(5, false))));

    model.addAttribute("purchaseHistory", List.of(
        purchaseHistoryItem("Nevermind", "Nirvana", "14/04/2026", "WaxWizard", "delivered",
            "Entregado", "29,90 €", "https://picsum.photos/seed/order1/120/120",
            "/transaction/leave-rating", vinylHref(4, true)),
        purchaseHistoryItem("Abbey Road", "The Beatles", "05/04/2026", "SpinMaster", "shipping",
            "En reparto", "28,50 €", "https://picsum.photos/seed/order2/120/120",
            "/transaction/leave-rating", vinylHref(2, true)),
        purchaseHistoryItem("Random Access Memories", "Daft Punk", "23/03/2026", "ClassicCuts",
            "delivered", "Entregado", "31,20 €", "https://picsum.photos/seed/order3/120/120",
            "/transaction/leave-rating", vinylHref(8, true))));

        return "profile";
    }

    @RequestMapping(value = "user/edit-profile", method = {RequestMethod.GET, RequestMethod.POST})
    public String editProfile() {
        log.info("Edit profile page requested");
        return "edit-profile";
    }

    @GetMapping("user/manage-my-vinyls")
    public String manageVinyls() {
        log.info("Manage my vinyls page requested");
        return "manage-my-vinyls";
    }
}