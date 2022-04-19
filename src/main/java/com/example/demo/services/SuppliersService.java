package com.example.demo.services;

import com.example.demo.controllers.CustomException;
import com.example.demo.dtos.requests.SupplierRequestDto;
import com.example.demo.dtos.response.SupplierResponseDto;
import com.example.demo.dtos.response.SuppliersResponseDto;
import com.example.demo.models.Firm;
import com.example.demo.models.Supplier;
import com.example.demo.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuppliersService {
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    public SupplierResponseDto authByLoginAndPassword(SupplierRequestDto supplierRequestDto) throws Exception{

        Supplier foundSupplier = supplierRepository.findByLoginAndPassword(supplierRequestDto.login, supplierRequestDto.password);

        if (foundSupplier == null) {
            throw CustomException.AuthException("Client credentials not found");
        }

        SupplierResponseDto firmResponseDto = modelMapper.map(foundSupplier, SupplierResponseDto.class);

        return firmResponseDto;
    }
}
