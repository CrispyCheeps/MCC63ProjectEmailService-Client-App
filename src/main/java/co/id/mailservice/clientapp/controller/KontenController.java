package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.service.KontenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/konten")
public class KontenController {

    private KontenService kontenService;

    @Autowired
    public KontenController(KontenService kontenService) {
        this.kontenService = kontenService;
    }
}
