package com.example.seminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(Model page,
                       @RequestParam(required=false) String color,
                       @RequestParam(required=false) String name) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }
}
