package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.helper.ExcelHelper;
import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.User;
import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import co.id.mailservice.clientapp.model.dto.LoginRequestData;
import co.id.mailservice.clientapp.model.dto.ParticipantData;
import co.id.mailservice.clientapp.model.dto.ResponseMessage;
import co.id.mailservice.clientapp.service.EmailListNameService;
import co.id.mailservice.clientapp.service.ParticipantService;
import co.id.mailservice.clientapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;
import java.util.List;

@Controller
@AllArgsConstructor
public class ParticipantController {

    private ParticipantService participantService;
    private UserService userService;

    @GetMapping("/participant")
    public String index(EmailListName emailListName, Authentication auth, Model model) {
        List<EmailListName> user= userService.findByEmail(auth.getName());
        model.addAttribute("users", user);
        return "CreateImportParticipantPage";
    }

    @PostMapping("/participant")
    public String create(@RequestParam("fileExcel") MultipartFile file, @RequestParam("emaiListNameId") Long emailListNameId) {

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                participantService.uploadFile(file, emailListNameId);

            } catch (Exception e) {

            }
        }
        participantService.uploadFile(file, emailListNameId);
        return "redirect:/dashboard";
    }

}

