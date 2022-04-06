/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.User;
import co.id.mailservice.clientapp.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Deanchristt
 */
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

//    @GetMapping
//    public String index(Model model, Authentication authentication) {
//        System.out.println(authentication);
//        model.addAttribute("regions", userService.getAll());
//        return "region/index";
//    }
//    @GetMapping("/create")
//    public String create(User user) {
//        return "region/create-form";
//    }
//
//    @PostMapping("/create")
//    public String create(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "user/create-form";
//        }
//
//        userService.create(user);
//        return "redirect:/user";
//    }
}
