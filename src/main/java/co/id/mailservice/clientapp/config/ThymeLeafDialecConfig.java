package co.id.mailservice.clientapp.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeLeafDialecConfig {

    @Bean
    public LayoutDialect layoutDialec() {
        return new LayoutDialect();
    }
}
