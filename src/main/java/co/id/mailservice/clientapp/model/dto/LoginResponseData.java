package co.id.mailservice.clientapp.model.dto;

import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.Konten;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class LoginResponseData {

    private String email;
    private List<EmailListName> emailListNameList;
    private List<Konten> kontens;
    private List<String> authorities;
}
