package com.example.demo.controllers;

import com.example.demo.dtos.response.FirmsResponseDto;
import com.example.demo.dtos.response.GoodsCategoryResponseDto;
import com.example.demo.repositories.GoodsCategoriesRepository;
import com.example.demo.services.GoodCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/goodCategories", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class GoodsCategoriesController {
    private final GoodCategoriesService goodCategoriesService;

    @GetMapping(value = "/getAll")
    public GoodsCategoryResponseDto getAll(){
        return goodCategoriesService.getAll();
    }
}
