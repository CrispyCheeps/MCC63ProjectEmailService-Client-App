package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.Template;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {

    private List<Template> templates = new ArrayList<>();
    private RestTemplate restTemplate;

    @Value("${app.baseUrl}/template")
    private String url;

    @Autowired
    public TemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Template> getAll() {
        List<Template> templates = new ArrayList<>();
        try {
            ResponseEntity<List<Template>> res = restTemplate
                    .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestHeader.createHeaders()),
                            new ParameterizedTypeReference<List<Template>>() {
                            });

            if (res.getStatusCode() == HttpStatus.OK) {
                return res.getBody();
            }
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Server unavailable");
        }
        return templates;
    }
}
