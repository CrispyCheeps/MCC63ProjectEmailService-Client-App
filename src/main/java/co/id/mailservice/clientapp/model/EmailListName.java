/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 *
 * @author Deanchristt
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailListName {

    private Long id;
    private String name;
    private User user;
    private List<Participant> participants;
    private ScheduleEmail scheduleEmail;
}
