package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import co.id.mailservice.clientapp.model.dto.ScheduleEmailData;
import co.id.mailservice.clientapp.service.ScheduleEmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ScheduleEmailController {

    private ScheduleEmailService scheduleEmailService;

    @Autowired
    public ScheduleEmailController(ScheduleEmailService scheduleEmailService) {
        this.scheduleEmailService = scheduleEmailService;
    }

    @GetMapping("/scheduleEmail")
    public String index(ScheduleEmailData scheduleEmailData) {
        return "CreateScheduleEmailPage";
    }

    @PostMapping("/scheduleEmail")
    public String create(@Valid ScheduleEmailData scheduleEmailData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "CreateScheduleEmailPage";
        }
        scheduleEmailService.addSchedule(scheduleEmailData);
        return "redirect:/Dashboard";
    }

}
