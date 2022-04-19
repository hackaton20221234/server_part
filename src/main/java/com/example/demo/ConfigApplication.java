package com.example.demo;

import com.example.demo.controllers.AuthInterceptor;
import com.example.demo.services.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class ConfigApplication implements WebMvcConfigurer {

    @Autowired
    private final AppsApiKeysService appsApiKeysService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(appsApiKeysService));
    }
}
