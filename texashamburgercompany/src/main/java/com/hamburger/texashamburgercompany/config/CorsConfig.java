package com.hamburger.texashamburgercompany.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = new String[]{"http://localhost:8080"};
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET","DELETE","POST","PUT")
                .allowedOrigins(origins);
    }
}
