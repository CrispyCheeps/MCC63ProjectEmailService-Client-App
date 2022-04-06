package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.Template;
import co.id.mailservice.clientapp.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/template")
public class TemplateController {

    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("authorities", SecurityContextHolder.getContext().getAuthentication());
        return "template/index2";
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<Template>> getAll() {
        return ResponseEntity.ok(templateService.getAll());
    }
}
