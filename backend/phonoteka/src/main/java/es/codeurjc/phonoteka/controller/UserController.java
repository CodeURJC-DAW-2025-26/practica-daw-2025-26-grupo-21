package es.codeurjc.phonoteka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.codeurjc.phonoteka.service.UserService;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
    model.addAttribute("profileUsername", userService.getUsername());
    model.addAttribute("memberSince", userService.getMemberSince());
    model.addAttribute("salesCount", userService.getSalesCount());
    model.addAttribute("ratingsCount", userService.getRatingsCount());
    model.addAttribute("ratingIcons", userService.getRatingIcons());
    model.addAttribute("profileAvatar", userService.getProfileAvatar());
    model.addAttribute("sellingVinyls", userService.getSellingVinyls());
    model.addAttribute("receivedReviews", userService.getReceivedReviews());
    model.addAttribute("purchaseHistory", userService.getPurchaseHistory());

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