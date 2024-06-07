package com.acme.recytechbackend.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI recyTechOpenApi() {
        // General configuration
        var openAPI = new OpenAPI();
        openAPI.info(new Info()
                        .title("RecyTech Backend")
                        .description("RecyTech Backend application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License()
                                .name("Apache 1.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("RecyTech Backend wiki Documentation.")
                        .url("https://recy-tech-backend.wiki.github.io/docs"));
        return openAPI;

    }
}