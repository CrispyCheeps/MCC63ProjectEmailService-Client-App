package co.id.mailservice.clientapp.controller;

import co.id.mailservice.clientapp.model.dto.ScheduleEmailData;
import co.id.mailservice.clientapp.service.ScheduleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SendNowController {

    private ScheduleEmailService scheduleEmailService;

    @Autowired
    public SendNowController(ScheduleEmailService scheduleEmailService) {
        this.scheduleEmailService = scheduleEmailService;
    }

    @GetMapping("/sendNow")
    public String index(ScheduleEmailData scheduleEmailData) {
        return "SendNowPage";
    }

    @PostMapping("/sendNow")
    public String sendNow(@Valid ScheduleEmailData scheduleEmailData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "SendNowPage";
        }
        scheduleEmailService.addSchedule(scheduleEmailData);
        return "redirect:/dashboard";
    }

}
