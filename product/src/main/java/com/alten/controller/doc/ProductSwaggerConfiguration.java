package com.alten.controller.doc;

import com.alten.configuration.AbstractSwaggerConfig;
import com.alten.configuration.LocalResolverConfiguration;
import com.alten.controller.api.ProductController;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSwaggerConfiguration extends AbstractSwaggerConfig {
    @Bean
    public GroupedOpenApi apiProduct() {
        String basePackage = ProductController.class.getPackage().getName();
        return super.createPreConfiguredApi(LocalResolverConfiguration.getMessage("product.docs.group.name"), basePackage);
    }
}
