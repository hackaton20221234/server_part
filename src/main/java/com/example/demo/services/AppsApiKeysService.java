package com.example.demo.services;

import com.example.demo.models.AppApiKey;
import com.example.demo.repositories.AppsApiKeysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppsApiKeysService {
    private final AppsApiKeysRepository appsApiKeysRepository;

    public AppApiKey getByKeyAndDeviceId(String key, String deviceId) {
        return appsApiKeysRepository.getByKeyAndDeviceId(key, deviceId);
    }
}
