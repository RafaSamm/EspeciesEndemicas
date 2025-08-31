package br.com.rhssolutions.especiesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EspeciesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspeciesApiApplication.class, args);
    }

}
