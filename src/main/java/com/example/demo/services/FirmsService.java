package com.example.demo.services;

import com.example.demo.dtos.errors.CustomException;
import com.example.demo.dtos.requests.FirmRequestDto;
import com.example.demo.dtos.response.FirmResponseDto;
import com.example.demo.dtos.response.FirmsResponseDto;
import com.example.demo.models.Firm;
import com.example.demo.repositories.FirmsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FirmsService {
    private final ModelMapper modelMapper;
    private final FirmsRepository firmsRepository;

    public FirmsResponseDto getAll() {
        ArrayList<FirmResponseDto> faqs = (ArrayList<FirmResponseDto>) firmsRepository
                .findAll().stream().map(
                        good -> modelMapper.map(good, FirmResponseDto.class)
                ).collect(Collectors.toList());
        return new FirmsResponseDto(faqs);
    }

    public FirmResponseDto authByLoginAndPassword(FirmRequestDto firmRequestDto) throws Exception{

        Firm foundFirm = firmsRepository.findByLoginAndPassword(firmRequestDto.login, firmRequestDto.password);

        if (foundFirm == null) {
            throw CustomException.AuthException("Client credentials not found");
        }

        FirmResponseDto firmResponseDto = modelMapper.map(foundFirm, FirmResponseDto.class);

        return firmResponseDto;
    }
}
