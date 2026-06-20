package es.codeurjc.phonoteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import es.codeurjc.phonoteka.service.AdminService;
import static es.codeurjc.phonoteka.utils.PhonotekaLogger.log;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        log.info("Admin dashboard page requested");
        return "admin-dashboard";
    }

    @GetMapping("/admin/users")
    public String users() {
        log.info("Admin users page requested");
        return "admin-users";
    }

    @GetMapping("/admin/vinyls")
    public String vinyls() {
        log.info("Admin vinyls page requested");
        return "admin-vinyls";
    }
}