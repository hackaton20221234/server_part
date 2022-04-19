package com.example.demo.repositories;

import com.example.demo.models.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmsRepository extends JpaRepository<Firm, Integer> {
    Firm findByLoginAndPassword(String login, String password);
}
