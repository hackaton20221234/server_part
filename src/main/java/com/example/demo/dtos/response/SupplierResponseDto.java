package com.example.demo.dtos.response;

import lombok.Data;

@Data
public class SupplierResponseDto {
    public int id;
    public String name;
    public String login;
    public int passport;
    public String city;
}
