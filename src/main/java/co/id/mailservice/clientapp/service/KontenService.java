package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.model.Konten;
import co.id.mailservice.clientapp.model.dto.KontenData;
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
public class KontenService {

    private RestTemplate restTemplate;

    @Autowired
    public KontenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseurl}/konten")
    private String url;

    public List<Konten> getAll() {
        List<Konten> regions = new ArrayList<>();
        try{
            ResponseEntity<List<Konten>> response = restTemplate
                    .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestHeader.createHeaders()),
                            new ParameterizedTypeReference<List<Konten>>() {});

            if(response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        }catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Server unavailable");
        }

        return regions;
    }

    public void create(KontenData kontenData) {
        try {
            restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(kontenData),
                    new ParameterizedTypeReference<KontenData>() {}
            );
        } catch (ResponseStatusException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }

    }
}
