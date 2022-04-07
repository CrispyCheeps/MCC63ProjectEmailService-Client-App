package co.id.mailservice.clientapp.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ParticipantData {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "email is required")
    private String email;

    private Long emailListNameId;

}
