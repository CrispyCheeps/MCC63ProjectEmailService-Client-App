package co.id.mailservice.clientapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplcateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
