package com.example.demo.controllers;

import com.example.demo.models.AppApiKey;
import com.example.demo.services.AppsApiKeysService;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final AppsApiKeysService appsApiKeysService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        if (uri.equals("apps/authByLoginAndPassword") == true) {
            return true;
        }

        String apiKey = request.getHeader("API_KEY");
        String deviceId = request.getHeader("DEVICE_ID");

        AppApiKey appApiKey = appsApiKeysService.getByKeyAndDeviceId(apiKey, deviceId);

        if (appApiKey == null) {
            throw CustomException.LogicException("app key not found");
        }

        /*long timestamp = currentTimeMillis();

        if (timestamp > appApiKey.finishTime) {
            throw CustomException.LogicException("app key expired");
        }*/

        return true;
    }
}
