/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.User;

import java.util.List;

import co.id.mailservice.clientapp.model.dto.UserData;
import co.id.mailservice.clientapp.utility.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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

    public List<EmailListName> findByEmail(String email) {
        try {
            ResponseEntity<List<EmailListName>> res = restTemplate.exchange(url.concat("/findByEmail/" + email), HttpMethod.GET,
                    new HttpEntity<>(RequestHeader.createHeaders()),
                    //response body nya berbentuk apa
                    new ParameterizedTypeReference<List<EmailListName>>() {
            });
            if(res.getStatusCode() == HttpStatus.OK) {
                return res.getBody();
            }
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }
        return null;
    }
    
    public void create(UserData userData) {
        int id = 1;
        Long userId = Long.valueOf(id);
        userData.setRoleId(userId);
        try {
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
