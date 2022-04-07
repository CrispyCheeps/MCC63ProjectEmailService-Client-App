//package co.id.mailservice.clientapp.controller;
//
//import co.id.mailservice.clientapp.model.EmailListName;
//import co.id.mailservice.clientapp.model.dto.EmailListNameData;
//import co.id.mailservice.clientapp.model.dto.LoginRequestData;
//import co.id.mailservice.clientapp.model.dto.ParticipantData;
//import co.id.mailservice.clientapp.service.ParticipantService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.validation.Valid;
//
//@Controller
//@AllArgsConstructor
//public class ParticipantController {
//
//    private ParticipantService participantService;
//    @GetMapping("/login")
//    public String login(LoginRequestData loginRequestData) {
//        return "LoginPage";
//    }
//
//    @GetMapping("/participant")
//    public String index(EmailListName emailListName) {
//        return "CreateImportParticipantPage";
//    }
//
//    @PostMapping("/participant")
//    public String create(@Valid @RequestParam("fileExcel") MultipartFile file, @Valid EmailListName emailListName) {
//        participantService.uploadFile(file, emailListName);
//        return "redirect:/dashboard";
//    }
//
//}
