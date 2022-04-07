package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ParticipantService {

    private RestTemplate restTemplate;

    @Autowired
    public ParticipantService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseUrl}/participant")
    private String url;

    public void uploadFile(MultipartFile multipartFile) {
        try {
            ResponseEntity<MultipartFile> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(multipartFile),
                    new ParameterizedTypeReference<MultipartFile>() {
                    }
            );
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }
    }


}
