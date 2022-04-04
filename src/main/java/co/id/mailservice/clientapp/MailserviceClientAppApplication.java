package co.id.mailservice.clientapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailserviceClientAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserviceClientAppApplication.class, args);
        System.out.println("Client App is running");
    }

}
