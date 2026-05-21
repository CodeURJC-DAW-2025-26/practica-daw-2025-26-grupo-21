package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @GetMapping("user/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("user/edit-profile")
    public String editProfile() {
        return "edit-profile";
    }

    @GetMapping("user/manage-my-vinyls")
    public String manageVinyls() {
        return "manage-my-vinyls";
    }
}