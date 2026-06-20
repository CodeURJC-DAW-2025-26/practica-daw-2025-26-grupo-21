package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import es.codeurjc.phonoteka.service.VinylService;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;

@Controller
public class VinylController {

    @Autowired
    private VinylService vinylService;

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
        model.addAttribute("results", vinylService.searchVinyls(query));

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

        model.addAttribute("vinyl", vinylService.getVinylDetails(vinylId));
        model.addAttribute("reviews", vinylService.getReviews());
        model.addAttribute("similarVinyls", vinylService.getSimilarVinyls(logged));

        return "vinyl";
    }
}