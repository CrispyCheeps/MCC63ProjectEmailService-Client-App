/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.model.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author MSI-JO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestData {

    @NotEmpty(message = "email is required")
    private String email;
    
    @NotEmpty(message = "password is required")
    private String password;
}
