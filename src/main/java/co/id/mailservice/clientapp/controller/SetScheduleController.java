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
public class SetScheduleController {

    private ScheduleEmailService scheduleEmailService;

    @Autowired
    public SetScheduleController(ScheduleEmailService scheduleEmailService) {
        this.scheduleEmailService = scheduleEmailService;
    }

    @GetMapping("/setSchedule")
    public String index(ScheduleEmailData scheduleEmailData) {
        return "SetSchedulePage";
    }

    @PostMapping("/setSchedule")
    public String sendNow(@Valid ScheduleEmailData scheduleEmailData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "SetSchedulePage";
        }
        scheduleEmailService.addSchedule(scheduleEmailData);
        return "redirect:/dashboard";
    }

}
