package es.codeurjc.phonoteka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/admin/users")
    public String users() {
        return "admin-users";
    }

    @GetMapping("/admin/vinyls")
    public String vinyls() {
        return "admin-vinyls";
    }
}