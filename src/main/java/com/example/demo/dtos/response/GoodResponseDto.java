package com.example.demo.dtos.response;

import lombok.Data;

@Data
public class GoodResponseDto {
    public int id;
    public String name;
    public int price;
    public SupplierResponseDto supplier;
    public String photoPath;
    public int goodsCategoryId;
}
