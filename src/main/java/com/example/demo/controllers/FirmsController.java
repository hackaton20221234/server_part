package com.example.demo.controllers;

import com.example.demo.dtos.response.FirmsResponseDto;
import com.example.demo.services.FirmsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/firms", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class FirmsController {
    private FirmsService firmsService;

    @GetMapping(value = "/getAll")
    public FirmsResponseDto getAll(){
        return firmsService.getAll();
    }
}
