package com.example.demo.services;

import com.example.demo.controllers.CustomException;
import com.example.demo.dtos.requests.AppAuthRequestDto;
import com.example.demo.dtos.response.AppAuthResponseDto;
import com.example.demo.models.App;
import com.example.demo.models.AppApiKey;
import com.example.demo.repositories.AppsApiKeysRepository;
import com.example.demo.repositories.AppsRepository;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

import static java.lang.System.currentTimeMillis;

@Service
@AllArgsConstructor
public class AppsService {
    private final AppsRepository appsRepository;
    private final AppsApiKeysRepository appsApiKeysRepository;

    @Transactional
    public AppAuthResponseDto authByLoginAndPassword(AppAuthRequestDto appAuthRequestDto) throws Exception {

        App foundApp = appsRepository.findByLoginAndPassword(appAuthRequestDto.login, appAuthRequestDto.password);

        if (foundApp == null) {
            throw CustomException.AuthException("App credentials not found");
        }

        appsApiKeysRepository.deleteByDeviceId(appAuthRequestDto.deviceId);

        long timestamp = currentTimeMillis();

        String dataForHash = foundApp.login + foundApp.password + appAuthRequestDto.deviceId + timestamp;

        String apiKey = Hashing.sha256().hashString(dataForHash, StandardCharsets.UTF_8).toString();

        int millisecondsInDay = 86400 * 1000;
        int days = 7;

        long finishTime = timestamp + days * millisecondsInDay;

        AppApiKey appApiKey = new AppApiKey(0, apiKey, finishTime, foundApp.id, appAuthRequestDto.deviceId);

        appsApiKeysRepository.saveAndFlush(appApiKey);

        return new AppAuthResponseDto(apiKey);
    }
}
