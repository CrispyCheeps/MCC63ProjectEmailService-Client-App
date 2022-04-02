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

/**
 *
 * @author Deanchristt
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Participant {
    private Long id;
    private String name;
    private String email;
    private EmailListName emailListName;
}
