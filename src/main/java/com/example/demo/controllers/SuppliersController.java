package com.example.demo.controllers;

import com.example.demo.dtos.requests.FirmRequestDto;
import com.example.demo.dtos.requests.SupplierRequestDto;
import com.example.demo.dtos.response.FirmResponseDto;
import com.example.demo.dtos.response.SupplierResponseDto;
import com.example.demo.services.SuppliersService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;

@RestController
@RequestMapping(path = "/suppliers", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class SuppliersController {
    private SuppliersService suppliersService;

    @PostMapping(value = "/authByLoginAndPassword")
    public SupplierResponseDto authByLoginAndPassword(@RequestBody @Valid SupplierRequestDto supplierRequestDto) throws Exception {
        return suppliersService.authByLoginAndPassword(supplierRequestDto);
    }

    @GetMapping(value = "/getPictureByName/{pictureName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getPictureByName(@PathVariable String pictureName) throws Exception {
        FileInputStream inputStream = new FileInputStream("images/suppliers/" + pictureName);
        return IOUtils.toByteArray(inputStream);
    }
}
