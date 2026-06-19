package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylCard;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "false") boolean logged, Model model) {
        log.info("Home page requested");

        model.addAttribute("pageTitle", "La Phonoteka - Descubre y Colecciona Vinilos");
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
        model.addAttribute("vinyls", List.of(
                vinylCard("The Dark Side of the Moon", "Pink Floyd", "Rock progresivo", "35,00 €",
                        "https://picsum.photos/seed/home1/400/400",
                        "Portada de The Dark Side of the Moon", "/vinyl?logged=true"),
                vinylCard("Abbey Road", "The Beatles", "Rock", "28,50 €",
                        "https://picsum.photos/seed/home2/400/400",
                        "Portada de Abbey Road", "/vinyl?logged=true"),
                vinylCard("Nevermind", "Nirvana", "Grunge", "29,90 €",
                        "https://picsum.photos/seed/home3/400/400",
                        "Portada de Nevermind", "/vinyl?logged=true"),
                vinylCard("Currents", "Tame Impala", "Psychedelic Pop", "38,00 €",
                        "https://picsum.photos/seed/home4/400/400",
                        "Portada de Currents", "/vinyl?logged=true")));

        return "index";
    }
}
