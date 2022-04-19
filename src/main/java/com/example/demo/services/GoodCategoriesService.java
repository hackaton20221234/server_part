package com.example.demo.services;

import com.example.demo.dtos.response.GoodsCategoryResponseDto;
import com.example.demo.models.GoodsCategory;
import com.example.demo.repositories.GoodsCategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class GoodCategoriesService {
    private final GoodsCategoriesRepository goodsCategoriesRepository;

    public GoodsCategoryResponseDto getAll(){
        ArrayList<GoodsCategory> goodsCategories = (ArrayList<GoodsCategory>) goodsCategoriesRepository.findAll();
        return new GoodsCategoryResponseDto(goodsCategories);
    }
}
