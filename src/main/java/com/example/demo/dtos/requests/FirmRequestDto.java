package com.example.demo.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FirmRequestDto {
    @NotEmpty
    public String login;

    @NotEmpty
    public String password;
}
