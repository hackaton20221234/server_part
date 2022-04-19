package com.example.demo.dtos.response;

import com.example.demo.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class GoodsResponseDto {
    public ArrayList<GoodResponseDto> goods;
}
