package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.dto.EmailListNameData;
import co.id.mailservice.clientapp.model.dto.ScheduleEmailData;
import lombok.AllArgsConstructor;
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

@Service
public class ScheduleEmailService {

    private RestTemplate restTemplate;

    @Autowired
    public ScheduleEmailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseUrl}/scheduleEmail")
    private String url;

    public void addSchedule(ScheduleEmailData scheduleEmailData) {
        try {
            ResponseEntity<ScheduleEmailData> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(scheduleEmailData),
                    new ParameterizedTypeReference<ScheduleEmailData>() {
                    }
            );
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }
    }

}
