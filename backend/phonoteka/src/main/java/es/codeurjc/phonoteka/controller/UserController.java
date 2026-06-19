package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class UserController {

    @GetMapping("user/profile")
    public String profile() {
        log.info("User profile page requested");
        return "profile";
    }

    @GetMapping("user/edit-profile")
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