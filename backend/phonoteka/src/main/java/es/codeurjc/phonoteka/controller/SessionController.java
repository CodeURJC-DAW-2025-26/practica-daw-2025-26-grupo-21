package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class SessionController {
    
    @RequestMapping(value = "/session/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, @RequestParam(required = false) String email,
            @RequestParam(required = false) String password) {
        log.info("Login page requested");
        model.addAttribute("pageTitle", "Iniciar Sesión - La Phonoteka");
        model.addAttribute("styles", List.of("/css/style.css", "/css/login.css"));
        model.addAttribute("homeHref", "/");
        model.addAttribute("showSearchBar", true);
        model.addAttribute("searchValue", "");
        model.addAttribute("searchPlaceholder", "Buscar en la colección...");
        model.addAttribute("showCartButton", false);
        model.addAttribute("showProfileLink", false);
        model.addAttribute("showAuthButtons", true);
        model.addAttribute("loginHref", "/session/login");
        model.addAttribute("registerHref", "/session/register");
        model.addAttribute("email", email == null ? "" : email);

        return "login";
    }

    @GetMapping("/session/register")
    public String register(Model model) {
        log.info("Register page requested");
        model.addAttribute("pageTitle", "Registro - La Phonoteka");
        model.addAttribute("styles", List.of("/css/style.css", "/css/register.css"));
        model.addAttribute("homeHref", "/");
        model.addAttribute("showSearchBar", true);
        model.addAttribute("searchValue", "");
        model.addAttribute("searchPlaceholder", "Buscar en la colección...");
        model.addAttribute("showCartButton", false);
        model.addAttribute("showProfileLink", false);
        model.addAttribute("showAuthButtons", true);
        model.addAttribute("loginHref", "/session/login");
        model.addAttribute("registerHref", "/session/register");
        return "register";
    }

}
