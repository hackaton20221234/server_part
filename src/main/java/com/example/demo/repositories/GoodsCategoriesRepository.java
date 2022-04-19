package com.example.demo.repositories;

import com.example.demo.models.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoriesRepository extends JpaRepository<GoodsCategory, Integer> {
}
