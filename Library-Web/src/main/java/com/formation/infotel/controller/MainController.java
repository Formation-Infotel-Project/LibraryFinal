package com.formation.infotel.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/index")
    public String home(Model model){

        SecurityContext context = SecurityContextHolder.getContext();

        model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName());
        return "index";
    }

    @GetMapping("/")
    public String index(Model model){

        SecurityContext context = SecurityContextHolder.getContext();

        model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "loginPages/login";
    }
}