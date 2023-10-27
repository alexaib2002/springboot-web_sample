package org.alexaib.springlearn.springweblearn.controllers;

import org.alexaib.springlearn.springweblearn.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping({"", "/app"})
public class IndexController {

    @Value("${msg.index_controller.index.title}")
    private String indexStr;

    @Value("${msg.index_controller.profile.title}")
    private String profileStr;

    @Value("${msg.index_controller.list.title}")
    private String listStr;

    @GetMapping({"", "/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("title", indexStr);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = new User("Marcos", "Robles", "marcos@email.net");
        model.addAttribute("title", String.format(profileStr, user.name()));
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", listStr);
        return "list";
    }

    /**
     * Called by Spring everytime the attribute 'users' is referenced.
     * This is caused by the @ModelAttribute annotation.
     * @return Generic user list
     */
    @ModelAttribute("users")
    private List<User> populateUsers() {
        return Arrays.asList(
                new User("Marcos", "Robles", "marcos@email.net"),
                new User("Pedro", "Martinez", "marcos@email.net"),
                new User("Juan", "Peñas", "marcos@email.net")
        );
    }

}
