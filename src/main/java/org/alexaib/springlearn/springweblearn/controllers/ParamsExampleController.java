package org.alexaib.springlearn.springweblearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

    @GetMapping({"", "/"})
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(required = false, defaultValue = "Undefined :(") String text, Model model) {
        model.addAttribute("result", String.format("Passed text: %s", text));
        return "params/view";
    }

}
