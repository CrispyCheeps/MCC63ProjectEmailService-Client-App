/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.model.dto;

import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.Konten;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Deanchristt
 */
@Data
public class LoginResponseData {
    private String email;
    private List<EmailListName> emailListName;
    private List<Konten> konten;
    //kalau ga ada previlege cuma ada role
    private List<String> authorities;
}
