package com.ra.session4.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {
    @GetMapping ("/greet")
    public String greet(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "greet";
    }
}
