package com.example.demo.repositories;

import com.example.demo.models.Firm;
import com.example.demo.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findByLoginAndPassword(String login, String password);
}
