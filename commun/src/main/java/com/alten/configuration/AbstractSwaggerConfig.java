package com.alten.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class AbstractSwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(LocalResolverConfiguration.getMessage("project.open.api.title"))
                        .version(LocalResolverConfiguration.getMessage("project.open.api.version"))
                        .description(LocalResolverConfiguration.getMessage("project.open.api.description"))
                );
    }

    public GroupedOpenApi createPreConfiguredApi(String groupName, String basePackage) {
        return GroupedOpenApi.builder()
                .group(groupName)
                .packagesToScan(basePackage)
                .build();
    }
}
