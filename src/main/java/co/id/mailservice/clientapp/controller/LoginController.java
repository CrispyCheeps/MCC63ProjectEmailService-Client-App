package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.dto.LoginRequestData;
import co.id.mailservice.clientapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(LoginRequestData loginRequestData) {
        return "LoginPage";
    }

    @PostMapping("/login")
    public String login(@Valid LoginRequestData loginRequestData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "LoginPage";
        }

        loginService.login(loginRequestData);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    @ResponseBody public String dashboard() {
        return "Dashboard";
    }
}
