package co.id.mailservice.clientapp.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class EmailListNameData {

    @NotEmpty(message = "name is required")
    private String name;
    private String userName;
}
