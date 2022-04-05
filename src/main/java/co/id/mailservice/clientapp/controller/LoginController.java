///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.id.mailservice.clientapp.controller;
//
//import co.id.mailservice.clientapp.model.dto.LoginRequestData;
//import co.id.mailservice.clientapp.service.LoginService;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author Deanchristt
// */
//@Controller
//public class LoginController {
//
//    private LoginService loginService;
//
//    @Autowired
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @GetMapping("/login")
//    public String login(LoginRequestData loginRequestData) {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@Valid LoginRequestData loginRequestData, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//
//        System.out.println(loginService.login(loginRequestData));
//        return "redirect:/dashboard";
//    }
//    
//
//    @GetMapping("/dashboard")
//    @ResponseBody
//    public String dashboard() {
//        return "Dashboard";
//    }
//}
