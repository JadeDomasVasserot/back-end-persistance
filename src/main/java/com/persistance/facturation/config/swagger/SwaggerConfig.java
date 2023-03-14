package com.persistance.facturation.config.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi facturationApi() {
        return GroupedOpenApi.builder()
                .group("Facturation API")
                .pathsToMatch("/**")
                .displayName("Facturation API")
                .build();
    }
}