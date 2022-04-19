package com.example.demo.repositories;

import com.example.demo.models.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppsRepository extends JpaRepository<App, Integer> {
    App findByLoginAndPassword(String login, String password);
}
