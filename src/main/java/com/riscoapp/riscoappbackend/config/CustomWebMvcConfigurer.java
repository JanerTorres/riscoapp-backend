package com.riscoapp.riscoappbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // Se permiten las solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Se permiten los siguientes HTTP
                .allowedHeaders("*");  // Permitir todos los encabezados
    }
}
