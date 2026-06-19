package es.codeurjc.phonoteka.controller;

import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;
import static es.codeurjc.phonoteka.utils.TemplateData.review;
import static es.codeurjc.phonoteka.utils.TemplateData.seller;
import static es.codeurjc.phonoteka.utils.TemplateData.stars;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylCard;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylHref;

@Controller
public class VinylController {

    private static final String[] VINYL_TITLES = {
        "The Dark Side of the Moon", "Abbey Road", "Thriller", "Nevermind", "Rumours",
        "IV", "Kind of Blue", "Random Access Memories", "A Night at the Opera", "Exodus",
        "London Calling", "To Pimp a Butterfly", "OK Computer", "Back to Black", "AM",
        "Is This It", "Ziggy Stardust", "Songs in the Key of Life", "Currents", "Blonde"
    };

    private static final String[] VINYL_ARTISTS = {
        "Pink Floyd", "The Beatles", "Michael Jackson", "Nirvana", "Fleetwood Mac",
        "Led Zeppelin", "Miles Davis", "Daft Punk", "Queen", "Bob Marley",
        "The Clash", "Kendrick Lamar", "Radiohead", "Amy Winehouse", "Arctic Monkeys",
        "The Strokes", "David Bowie", "Stevie Wonder", "Tame Impala", "Frank Ocean"
    };

    private static final String[] VINYL_GENRES = {
        "Rock progresivo", "Rock", "Pop", "Grunge", "Soft Rock",
        "Hard Rock", "Jazz", "Electronic", "Rock", "Reggae",
        "Punk", "Hip Hop", "Alternative", "Soul", "Indie Rock",
        "Indie Rock", "Glam Rock", "Soul", "Psychedelic Pop", "R&B"
    };

    private static final String[] VINYL_PRICES = {
        "35,00 €", "28,50 €", "31,00 €", "29,90 €", "26,50 €",
        "30,00 €", "24,00 €", "38,00 €", "33,00 €", "27,00 €",
        "25,50 €", "34,00 €", "27,50 €", "26,00 €", "33,50 €",
        "25,00 €", "32,50 €", "36,00 €", "31,50 €", "29,00 €"
    };

    private static final String[] VINYL_IMAGE_SEEDS = {
        "vinyl1", "vinyl2", "vinyl3", "vinyl4", "vinyl5",
        "vinyl6", "vinyl7", "vinyl8", "vinyl9", "vinyl10",
        "vinyl11", "vinyl12", "vinyl13", "vinyl14", "vinyl15",
        "vinyl16", "vinyl17", "vinyl18", "vinyl19", "vinyl20"
    };

    private static final String[] VINYL_SELLERS = {
        "a.morales.2019", "SpinMaster", "VinylVortex", "WaxWizard", "ClassicCuts",
        "GrooveGuardian", "RecordRebel", "AudioPhile101", "TurntableTamer", "DJ_Dusty",
        "a.morales.2019", "SpinMaster", "VinylVortex", "WaxWizard", "ClassicCuts",
        "GrooveGuardian", "RecordRebel", "AudioPhile101", "TurntableTamer", "DJ_Dusty"
    };

    @RequestMapping(value = "/vinyl/add", method = {RequestMethod.GET, RequestMethod.POST})
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
                vinylHref(1, true)),
            vinylCard("Wish You Were Here", "Pink Floyd", "Rock", "32,00 €",
                "https://picsum.photos/seed/pf2/400/400", "Portada de Wish You Were Here",
                vinylHref(2, true)),
            vinylCard("Animals", "Pink Floyd", "Rock progresivo", "31,50 €",
                "https://picsum.photos/seed/pf3/400/400", "Portada de Animals", vinylHref(5, true)),
            vinylCard("The Wall", "Pink Floyd", "Rock progresivo", "39,00 €",
                "https://picsum.photos/seed/pf4/400/400", "Portada de The Wall", vinylHref(4, true))));

        return "search-results";
    }

    @GetMapping({"/vinyl", "/vinyl/{id}"})
        public String vinyl(@PathVariable(required = false) Integer id,
                @RequestParam(defaultValue = "false") boolean logged, Model model) {
        log.info("Vinyl page requested");
        int vinylId = id == null ? 1 : id;

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

        model.addAttribute("vinyl", vinylDetails(vinylId));

        model.addAttribute("reviews", List.of(
            review("GrooveGuardian", "El vinilo llegó en perfecto estado y muy rápido.", stars(4, false)),
            review("WaxWizard", "¡Una joya! Comunicación excelente.", stars(5, false))));

        model.addAttribute("similarVinyls", List.of(
            vinylCard("Wish You Were Here", "Pink Floyd", "Rock", "32,00 €",
                "https://picsum.photos/seed/similar1/100/100", "Portada de Wish You Were Here",
                vinylHref(2, logged)),
            vinylCard("IV", "Led Zeppelin", "Rock", "30,00 €",
                "https://picsum.photos/seed/similar2/100/100", "Portada de IV", vinylHref(6, logged)),
            vinylCard("OK Computer", "Radiohead", "Alternative", "27,50 €",
                "https://picsum.photos/seed/similar3/100/100", "Portada de OK Computer",
                vinylHref(13, logged)),
            vinylCard("The Wall", "Pink Floyd", "Rock", "39,00 €",
                "https://picsum.photos/seed/similar4/100/100", "Portada de The Wall", vinylHref(4, logged)),
            vinylCard("Animals", "Pink Floyd", "Rock progresivo", "31,50 €",
                "https://picsum.photos/seed/similar5/100/100", "Portada de Animals", vinylHref(5, logged))));

        return "vinyl";
    }

    private Map<String, Object> vinylDetails(int id) {
        int index = Math.floorMod(id - 1, VINYL_TITLES.length);
        String title = VINYL_TITLES[index];
        String artist = VINYL_ARTISTS[index];
        String genre = VINYL_GENRES[index];
        String sellerName = VINYL_SELLERS[index];

        return Map.of(
            "image", "https://picsum.photos/seed/" + VINYL_IMAGE_SEEDS[index] + "/600/600",
            "alt", "Portada de " + title,
            "title", title,
            "artist", artist,
            "description", "Un álbum destacado de " + artist + " dentro del " + genre.toLowerCase()
                + ". Es una pieza imprescindible para cualquier colección de vinilos.",
            "price", VINYL_PRICES[index],
            "seller", seller(sellerName, "https://i.pravatar.cc/80?u=" + sellerName,
                "/user/profile", stars(4, true)));
    }
   
}