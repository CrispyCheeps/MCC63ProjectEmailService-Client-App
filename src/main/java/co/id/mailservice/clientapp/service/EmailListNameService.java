package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.User;
import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.Charset;

@Service
public class EmailListNameService {

    private RestTemplate restTemplate;

    @Autowired
    public EmailListNameService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseUrl}/emailListName")
    private String url;

    public void create(EmailListNameData emailListNameData) {
        try {
            ResponseEntity<EmailListNameData> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(emailListNameData),
                    new ParameterizedTypeReference<EmailListNameData>() {
                    }
            );
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }
    }

}
