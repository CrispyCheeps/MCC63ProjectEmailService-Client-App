package co.id.mailservice.clientapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplcateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if (interceptors.isEmpty()) {
            interceptors = new ArrayList<>();
        }

        interceptors.add(new RestTemplateInterceptorHeader());

        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
