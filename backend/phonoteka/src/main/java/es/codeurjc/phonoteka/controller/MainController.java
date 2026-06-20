package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.codeurjc.phonoteka.service.VinylService;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;

@Controller
public class MainController {

    @Autowired
    private VinylService vinylService;

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "false") boolean logged, Model model) {
        log.info("Home page requested");

        model.addAttribute("pageTitle", "La Phonoteka - Descubre y Colecciona Vinylos");
        model.addAttribute("styles", List.of("/css/style.css"));
        model.addAttribute("homeHref", logged ? "/?logged=true" : "/");
        model.addAttribute("showSearchBar", true);
        model.addAttribute("searchValue", "");
        model.addAttribute("searchPlaceholder", "¿Qué buscas hoy?");
        model.addAttribute("showCartButton", logged);
        model.addAttribute("cartCount", 0);
        model.addAttribute("showProfileLink", logged);
        model.addAttribute("profileHref", "/user/profile");
        model.addAttribute("profileLabel", "Mi Perfil");
        model.addAttribute("showAuthButtons", !logged);
        model.addAttribute("showCartDrawer", logged);
        model.addAttribute("loginHref", "/session/login");
        model.addAttribute("registerHref", "/session/register");
        model.addAttribute("heroTitle", logged ? "Bienvenido de nuevo, Adrián"
                : "Descubre, Colecciona y Vende Vinilos");
        model.addAttribute("heroText", logged ? "Sigue explorando las joyas que tenemos para tu colección."
                : "El punto de encuentro para amantes de la música en formato físico.");
        model.addAttribute("vinyls", vinylService.getFeaturedVinyls(logged));

        return "index";
    }
}
