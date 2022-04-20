package com.example.demo.controllers;

import com.example.demo.dtos.requests.FirmRequestDto;
import com.example.demo.dtos.response.FirmResponseDto;
import com.example.demo.dtos.response.FirmsResponseDto;
import com.example.demo.services.FirmsService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/firms", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class FirmsController {
    private FirmsService firmsService;

    @GetMapping(value = "/getAll")
    public FirmsResponseDto getAll(){
        return firmsService.getAll();
    }

    @PostMapping(value = "/authByLoginAndPassword")
    public FirmResponseDto authByLoginAndPassword(@RequestBody @Valid FirmRequestDto firmRequestDto) throws Exception {
        return firmsService.authByLoginAndPassword(firmRequestDto);
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/firms/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
