package com.alten.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class LocalResolverConfiguration {

    private static MessageSource messageSource;
    private static LocalResolverConfiguration localResolverConfiguration;

    public static String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages","documentation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.FRENCH);
        return localeResolver;
    }

    private static void setLocalResolverConfiguration(LocalResolverConfiguration localResolverConfiguration) {
        LocalResolverConfiguration.localResolverConfiguration = localResolverConfiguration;
    }

    @PostConstruct
    public void init(){
        messageSource = messageSource();
        LocalResolverConfiguration.setLocalResolverConfiguration(this);
    }
}
