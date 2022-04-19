package com.example.demo.controllers;

import com.example.demo.dtos.requests.AppAuthRequestDto;
import com.example.demo.dtos.response.AppAuthResponseDto;
import com.example.demo.services.AppsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/apps", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class AppsController {
    private final AppsService appsService;

    @PostMapping(value = "/authByLoginAndPassword")
    public AppAuthResponseDto authByLoginAndPassword(@RequestBody @Valid AppAuthRequestDto appAuthRequestDto) throws Exception {
        return appsService.authByLoginAndPassword(appAuthRequestDto);
    }
}
