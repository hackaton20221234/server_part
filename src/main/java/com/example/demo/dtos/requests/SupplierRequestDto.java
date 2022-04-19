package com.example.demo.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SupplierRequestDto {
    @NotEmpty
    public String login;

    @NotEmpty
    public String password;
}
