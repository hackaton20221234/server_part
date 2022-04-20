package com.example.demo.controllers;

import com.example.demo.dtos.response.FirmsResponseDto;
import com.example.demo.dtos.response.GoodsCategoryResponseDto;
import com.example.demo.repositories.GoodsCategoriesRepository;
import com.example.demo.services.GoodCategoriesService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/goodCategories", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class GoodsCategoriesController {
    private final GoodCategoriesService goodCategoriesService;

    @GetMapping(value = "/getAll")
    public GoodsCategoryResponseDto getAll(){
        return goodCategoriesService.getAll();
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/goodcategories/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
