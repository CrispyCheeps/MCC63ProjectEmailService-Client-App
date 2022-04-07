package co.id.mailservice.clientapp.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ScheduleEmailData {

    @NotEmpty(message = "emailListName is required")
    private String emailListName;

    @NotEmpty(message = "konten is required")
    private String subject;

    private String tanggalKirim;

}
