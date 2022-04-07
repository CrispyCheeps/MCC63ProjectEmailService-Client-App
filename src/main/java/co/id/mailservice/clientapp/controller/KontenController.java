package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.Konten;
import co.id.mailservice.clientapp.model.dto.KontenData;
import co.id.mailservice.clientapp.model.dto.LoginRequestData;
import co.id.mailservice.clientapp.service.KontenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/konten")
public class KontenController {

    private KontenService kontenService;

    @Autowired
    public KontenController(KontenService kontenService) {
        this.kontenService = kontenService;
    }

    @GetMapping
    public String index(KontenData kontenData) {
        return "konten/index";
    }

    @PostMapping("/create")
    public String create(@Valid KontenData kontenData, BindingResult bindingResult, Authentication auth) {
        if (bindingResult.hasErrors()) {
            return "konten/index";
        }
        kontenData.setUserName(auth.getName());
        kontenService.create(kontenData);
        return "redirect:/dashboard";
    }
}
