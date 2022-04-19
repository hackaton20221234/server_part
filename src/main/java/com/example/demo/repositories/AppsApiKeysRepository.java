package com.example.demo.repositories;

import com.example.demo.models.AppApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppsApiKeysRepository extends JpaRepository<AppApiKey, Integer> {
    AppApiKey getByKeyAndDeviceId(String key, String deviceId);
    void deleteByDeviceId(String deviceId);
}
