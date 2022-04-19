package com.example.demo.repositories;

import com.example.demo.models.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GoodsRepository extends JpaRepository<Good, Integer> {
    ArrayList<Good> findAllByGoodCategoryId(int id);
}
