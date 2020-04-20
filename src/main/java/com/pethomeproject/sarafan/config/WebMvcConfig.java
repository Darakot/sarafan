package com.pethomeproject.sarafan.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Конфиг для будет перенаправлять запросы с несуществующих страниц на мэпинг http://localhost:8080/
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerCustomizer(){
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/"));
        };
    }
}
