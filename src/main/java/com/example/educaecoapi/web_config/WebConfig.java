package com.example.educaecoapi.web_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapeia todas as rotas
                .allowedOrigins(
                        "http://127.0.0.1:5500", // Para desenvolvimento local
                        "https://gats-organization.github.io" // Domínio do GitHub Pages
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowCredentials(true);
    }
}

