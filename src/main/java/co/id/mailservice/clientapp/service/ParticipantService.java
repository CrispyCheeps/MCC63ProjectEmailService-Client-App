package co.id.mailservice.clientapp.service;

import co.id.mailservice.clientapp.helper.ExcelHelper;
import co.id.mailservice.clientapp.model.EmailListName;
import co.id.mailservice.clientapp.model.dto.ParticipantData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParticipantService implements Serializable {

    private RestTemplate restTemplate;

    @Autowired
    public ParticipantService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.baseUrl}/participant")
    private String url;


    public Object readByteStreamFromFileAndDeSerializeToObject(String filename)
            throws IOException, ClassNotFoundException {
        Object object = null;
        System.out.printf("\nDe-serialization bytestream from file: %s", filename);
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename))) {
            object = reader.readObject();
        }

        return object;
    }

//    @JsonSerialize
    public void uploadFile(MultipartFile file, Long emailListNameId){
        try {

            List<ParticipantData> participantsData = ExcelHelper.excelToParticipants(file.getInputStream());
            ResponseEntity<MultipartFile> res = restTemplate.exchange(
                    url.concat("/upload/" + emailListNameId),
                    HttpMethod.POST,
                    new HttpEntity<>(participantsData),
                    new ParameterizedTypeReference<MultipartFile>() {
                    }
            );
        } catch (ResponseStatusException | IOException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        }


    }
}