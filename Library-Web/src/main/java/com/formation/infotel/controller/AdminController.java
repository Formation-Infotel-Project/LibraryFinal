package com.formation.infotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/administration")
    public String administration(){
        return "admin/administration";
    }

    @GetMapping("/addUser")
    public String addMember(){
        return "admin/addMember";
    }
}
