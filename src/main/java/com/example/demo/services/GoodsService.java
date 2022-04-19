package com.example.demo.services;

import com.example.demo.dtos.response.GoodResponseDto;
import com.example.demo.dtos.response.GoodsResponseDto;
import com.example.demo.repositories.GoodsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsService {
    private final ModelMapper modelMapper;
    private final GoodsRepository goodsRepository;

    public GoodsResponseDto getAll() {
        ArrayList<GoodResponseDto> goods = (ArrayList<GoodResponseDto>) goodsRepository
                .findAll().stream().map(
                        good -> modelMapper.map(good, GoodResponseDto.class)
                ).collect(Collectors.toList());

        return new GoodsResponseDto(goods);
    }

    public GoodsResponseDto getAllByCategoryId(int id) {
        ArrayList<GoodResponseDto> goods = (ArrayList<GoodResponseDto>) goodsRepository
                .findAllByGoodCategoryId(id).stream().map(
                        good -> modelMapper.map(good, GoodResponseDto.class)
                ).collect(Collectors.toList());
        return new GoodsResponseDto(goods);
    }
}
