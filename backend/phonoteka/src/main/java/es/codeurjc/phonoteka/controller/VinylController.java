package es.codeurjc.phonoteka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;
import static es.codeurjc.phonoteka.utils.TemplateData.review;
import static es.codeurjc.phonoteka.utils.TemplateData.seller;
import static es.codeurjc.phonoteka.utils.TemplateData.stars;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylCard;

@Controller
public class VinylController {

    @GetMapping("/vinyl/add")
    public String addVinyl() {
        log.info("Add vinyl page requested");
        return "add-vinyl";
    }

    @GetMapping("/vinyl/search")
        public String search(@RequestParam(defaultValue = "Pink Floyd") String query, Model model) {
        log.info("Search results page requested");

        model.addAttribute("pageTitle", "Search Results - La Phonoteka");
        model.addAttribute("styles", List.of("/css/style.css", "/css/search-results.css"));
        model.addAttribute("homeHref", "/?logged=true");
        model.addAttribute("showSearchBar", true);
        model.addAttribute("searchValue", query);
        model.addAttribute("searchPlaceholder", "Buscar en la colección...");
        model.addAttribute("showCartButton", false);
        model.addAttribute("showProfileLink", true);
        model.addAttribute("profileHref", "/user/profile");
        model.addAttribute("profileLabel", "Mi Perfil");
        model.addAttribute("showAuthButtons", false);
        model.addAttribute("showCartDrawer", false);
        model.addAttribute("query", query);
        model.addAttribute("resultCount", 4);
        model.addAttribute("results", List.of(
            vinylCard("The Dark Side of the Moon", "Pink Floyd", "Rock", "35,00 €",
                "https://picsum.photos/seed/pf1/400/400", "Portada de The Dark Side of the Moon",
                "/vinyl?logged=true"),
            vinylCard("Wish You Were Here", "Pink Floyd", "Rock", "32,00 €",
                "https://picsum.photos/seed/pf2/400/400", "Portada de Wish You Were Here",
                "/vinyl?logged=true"),
            vinylCard("Animals", "Pink Floyd", "Rock progresivo", "31,50 €",
                "https://picsum.photos/seed/pf3/400/400", "Portada de Animals", "/vinyl?logged=true"),
            vinylCard("The Wall", "Pink Floyd", "Rock progresivo", "39,00 €",
                "https://picsum.photos/seed/pf4/400/400", "Portada de The Wall", "/vinyl?logged=true")));

        return "search-results";
    }

    @GetMapping("/vinyl")
        public String vinyl(@RequestParam(defaultValue = "false") boolean logged, Model model) {
        log.info("Vinyl page requested");

        model.addAttribute("pageTitle", "Detalle del Vinilo - La Phonoteka");
        model.addAttribute("styles", List.of("/css/style.css", "/css/vinyl.css"));
        model.addAttribute("homeHref", logged ? "/?logged=true" : "/");
        model.addAttribute("showSearchBar", true);
        model.addAttribute("searchValue", "");
        model.addAttribute("searchPlaceholder", "Buscar en la colección...");
        model.addAttribute("showCartButton", logged);
        model.addAttribute("cartCount", 0);
        model.addAttribute("showProfileLink", logged);
        model.addAttribute("profileHref", "/user/profile");
        model.addAttribute("profileLabel", "Mi Perfil");
        model.addAttribute("showAuthButtons", !logged);
        model.addAttribute("loginHref", "/session/login");
        model.addAttribute("registerHref", "/session/register");
        model.addAttribute("showCartDrawer", logged);

        model.addAttribute("vinyl", Map.of(
            "image", "https://picsum.photos/seed/vinyl1/600/600",
            "alt", "Cover of The Dark Side of the Moon",
            "title", "The Dark Side of the Moon",
            "artist", "Pink Floyd",
            "description",
            "Un álbum conceptual y el octavo de estudio de la banda británica de rock progresivo. Es considerado una obra cumbre del rock y uno de los álbumes más vendidos de todos los tiempos.",
            "price", "35,00 €",
            "seller", seller("a.morales.2019", "https://i.pravatar.cc/80?u=a.morales.2019", "/user/profile",
                stars(4, true))));

        model.addAttribute("reviews", List.of(
            review("GrooveGuardian", "El vinilo llegó en perfecto estado y muy rápido.", stars(4, false)),
            review("WaxWizard", "¡Una joya! Comunicación excelente.", stars(5, false))));

        model.addAttribute("similarVinyls", List.of(
            vinylCard("Wish You Were Here", "Pink Floyd", "Rock", "32,00 €",
                "https://picsum.photos/seed/similar1/100/100", "Portada de Wish You Were Here",
                "/vinyl?logged=true"),
            vinylCard("IV", "Led Zeppelin", "Rock", "30,00 €",
                "https://picsum.photos/seed/similar2/100/100", "Portada de IV", "/vinyl?logged=true"),
            vinylCard("OK Computer", "Radiohead", "Alternative", "27,50 €",
                "https://picsum.photos/seed/similar3/100/100", "Portada de OK Computer",
                "/vinyl?logged=true"),
            vinylCard("The Wall", "Pink Floyd", "Rock", "39,00 €",
                "https://picsum.photos/seed/similar4/100/100", "Portada de The Wall", "/vinyl?logged=true"),
            vinylCard("Animals", "Pink Floyd", "Rock progresivo", "31,50 €",
                "https://picsum.photos/seed/similar5/100/100", "Portada de Animals", "/vinyl?logged=true")));

        return "vinyl";
    }
   
}