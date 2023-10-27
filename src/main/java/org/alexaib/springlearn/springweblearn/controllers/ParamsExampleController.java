package org.alexaib.springlearn.springweblearn.controllers;

import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/multiparam")
    public String multiparam(@RequestParam String string, @RequestParam Integer number, Model model) {
        model.addAttribute("result", String.format("Arguments: string -> %s\n\tnumber -> %d", string, number));
        return "params/view";
    }

    @GetMapping("/multiparam-with-request")
    public String multiparam(HttpServletRequest request, Model model) {
        String string = request.getParameter("string");
        int number = 0;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException ignored) { }

        model.addAttribute("result", String.format("Arguments: string -> %s\n\tnumber -> %d", string, number));
        return "params/view";
    }

}
