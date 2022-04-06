package co.id.mailservice.clientapp.model.dto;

import lombok.Data;

@Data
public class UserData {

    private Long id;
    private String name;
    private String password;
    private String email;
    private Long roleId;
}
