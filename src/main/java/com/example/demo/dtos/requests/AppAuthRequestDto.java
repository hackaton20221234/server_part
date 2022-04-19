package com.example.demo.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AppAuthRequestDto {

    @NotEmpty(message = "login must be full")
    public String login;
    @NotEmpty
    public String password;
    @NotEmpty
    public String deviceId;
}
