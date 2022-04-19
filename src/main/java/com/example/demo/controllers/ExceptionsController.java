package com.example.demo.controllers;

import com.example.demo.dtos.response.ExceptionResponseDto;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(CustomException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.toString());
        return new ResponseEntity<>(exceptionResponseDto, e.getHttpStatus());
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(DataAccessResourceFailureException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                "DataAccessResourceFailureException:db connection error");
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.toString());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }
}
