package br.com.rhssolutions.especiesAPI.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocConfig {

    @Bean
    private static OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Especies API")
                        .description("API para gerenciamento de espécies")
                        .version("1.0.0")
                        .contact(contato()))
                .servers(List.of(
                        new Server()
                                .url("https://especiesendemicas.onrender.com")
                                .description("Servidor de produção")
                        ,
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de desenvolvimento local")
                ));
    }


    @Bean
    private static Contact contato() {
        return new Contact()
                .name("RHSSolutions - Inovação e Qualidade de Software")
                .email("rhssolutions@gmail.com")
                .url("https://www.rhssolutions.com.br");

    }
}
