package co.id.mailservice.clientapp.model.dto;

import co.id.mailservice.clientapp.utility.RequestHeader;
import lombok.Data;
import org.springframework.security.core.Authentication;

@Data
public class KontenData {
    private String subject;
    private String body;
    private String footer;
    private String attachment;
    private String userName;
    private Long template;
}