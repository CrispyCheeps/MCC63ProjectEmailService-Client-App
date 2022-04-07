package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.User;
import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import co.id.mailservice.clientapp.service.EmailListNameService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class EmailListNameController {

    private EmailListNameService emailListNameService;

    @GetMapping("/emailListName")
    public String index(EmailListNameData emailListNameData) {
        return "CreateEmailListNamePage";
    }

    @PostMapping("/emailListName")
    public String create(@Valid EmailListNameData emailListNameData, BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "CreateEmailListNamePage";
        }
        emailListNameData.setUserName(authentication.getName());
        emailListNameService.create(emailListNameData);
        return "redirect:/participant";
    }

}
