package com.gl.TP7.controller;

import com.gl.TP7.model.User;
import com.gl.TP7.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String name, @RequestParam String email, @RequestParam String ville, @RequestParam String login, @RequestParam String pass) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setVille(ville);
        user.setLogin(login);
        user.setPass(pass);

        userRepository.save(user);

        return "redirect:/show/" + user.getIdUser();
    }

    @RequestMapping("/show/{idUser}")
    public String show(@PathVariable Integer idUser, Model model) {
        model.addAttribute("user", userRepository.findById(idUser).orElse(null));
        return "show";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String login, @RequestParam String pass) {
        if (login.equals("admin") && pass.equals("admin")) {
            return "redirect:/user";
        } else return "index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Integer idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        userRepository.delete(user);
        return "redirect:/user";
    }

    @RequestMapping("/edit/{idUser}")
    public String edit(@PathVariable Integer idUser, Model model) {
        model.addAttribute("user", userRepository.findById(idUser).orElse(null));
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam Integer idUser, @RequestParam String name, @RequestParam String email, @RequestParam String ville, @RequestParam String login, @RequestParam String pass) {
        User user = userRepository.findById(idUser).orElse(null);
        user.setName(name);
        user.setEmail(email);
        user.setVille(ville);
        user.setLogin(login);
        user.setPass(pass);

        userRepository.save(user);

        return "redirect:/show/" + user.getIdUser();
    }

}
