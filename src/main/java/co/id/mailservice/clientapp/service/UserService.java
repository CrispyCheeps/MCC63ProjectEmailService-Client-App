/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.User;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import co.id.mailservice.clientapp.model.dto.UserData;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Deanchristt
 */
@Service
public class UserService {

    private RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseUrl}/user")
    private String url;
    
    public void create(UserData userData) {
        userData.setRoleId(1L);
        try {
//            System.out.println(userData.getId());
//            System.out.println(userData.getName());
//            System.out.println(userData.getEmail());
//            System.out.println(userData.getPassword());
//            System.out.println(userData.getRoleId());
            restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(userData),
                    new ParameterizedTypeReference<User>() {
                    }
            );
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }
    }
}
