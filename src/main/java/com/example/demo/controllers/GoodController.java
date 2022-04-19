package com.example.demo.controllers;

import com.example.demo.dtos.response.GoodsResponseDto;
import com.example.demo.services.GoodsService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/goods", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class GoodController {
    private GoodsService goodsService;

    @GetMapping(value = "/getAllByCategoryId/{id}")
    public GoodsResponseDto getAll(@PathVariable int id){
        return goodsService.getAllByCategoryId(id);
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/goods/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
