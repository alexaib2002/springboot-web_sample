package org.alexaib.springlearn.springweblearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paths")
public class PathVarController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("number", 7);
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("result",
                String.format("Path variable: string -> %s", text));
        return "variables/view";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable int number, Model model) {
        model.addAttribute("result",
                String.format("Arguments: string -> %s\n\tnumber -> %d", text, number));
        return "variables/view";
    }

}
