//package co.id.mailservice.clientapp.service;
//
//import co.id.mailservice.clientapp.model.EmailListName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//
//@Service
//public class ParticipantService {
//
//    private RestTemplate restTemplate;
//
//    @Autowired
//    public ParticipantService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Value("${app.baseUrl}/participant")
//    private String url;
//
//    public void uploadFile(MultipartFile file, EmailListName emailListName) {
//        Long emailListNameId = emailListName.getId();
//        try {
//            /*
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            MultiValueMap<String, Object> body
//                    = new LinkedMultiValueMap<>();
//            body.add("file", file);
//
//            HttpEntity<MultiValueMap<String, Object>> requestEntity
//                    = new HttpEntity<>(body, headers);
//
//            ResponseEntity<MultipartFile> response = restTemplate.exchange(
//                    url.concat("/upload"),
//                    HttpMethod.POST,
//                    requestEntity,
//                    new ParameterizedTypeReference<MultipartFile>() {
//            }
//             */
//
//            ResponseEntity<MultipartFile> response = restTemplate.exchange(
//                    url,
//                    HttpMethod.POST,
//                    new HttpEntity<>(file),
//                    new ParameterizedTypeReference<MultipartFile>() {
//                    }
//            );
//        } catch (ResponseStatusException ex) {
//            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
//        }
//
//
//    }
//}