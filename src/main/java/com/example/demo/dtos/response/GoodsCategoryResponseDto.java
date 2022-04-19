package com.example.demo.dtos.response;

import com.example.demo.models.GoodsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class GoodsCategoryResponseDto {
    public ArrayList<GoodsCategory> goodsCategories;
}
