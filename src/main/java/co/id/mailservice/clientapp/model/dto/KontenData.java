package co.id.mailservice.clientapp.model.dto;

import lombok.Data;

@Data
public class KontenData {
    private String subject;
    private String body;
    private String footer;
    private String attachment;
    private String scheduleEmail;
    private Long user;
    private Long template;
}
