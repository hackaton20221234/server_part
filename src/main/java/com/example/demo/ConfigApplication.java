package com.example.demo;

import com.example.demo.services.AppsApiKeyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class ConfigApplication implements WebMvcConfigurer {

    @Autowired
    private final AppsApiKeyService appsApiKeyService;
}
