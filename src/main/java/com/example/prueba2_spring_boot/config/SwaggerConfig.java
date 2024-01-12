package com.example.prueba2_spring_boot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("Spring Boot proyect API CRUD")
                .version("2.0")
                .description("Test API in Srping Boot")
                .termsOfService("https://petstore.swagger.io")
                .contact(new Contact())
                .license(new License().name("Apache License").url("https://springdoc.org")));

    }
}
