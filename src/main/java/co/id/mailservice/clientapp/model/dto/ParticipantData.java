package co.id.mailservice.clientapp.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantData {
    private String name;
    private String email;
    private Long emailListNameId;
}
