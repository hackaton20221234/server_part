package com.example.demo.controllers;

import com.example.demo.dtos.response.GoodsResponseDto;
import com.example.demo.services.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/goods", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class GoodController {
    private GoodsService goodsService;

    @GetMapping(value = "/getAllByCategoryId/{id}")
    public GoodsResponseDto getAll(@PathVariable int id){
        return goodsService.getAllByCategoryId(id);
    }
}
