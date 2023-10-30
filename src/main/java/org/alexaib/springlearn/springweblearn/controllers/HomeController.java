package org.alexaib.springlearn.springweblearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/app/index";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/app/index";
    }

    @GetMapping("/google")
    public String google() {
        return "redirect:https://www.google.com";
    }

}
