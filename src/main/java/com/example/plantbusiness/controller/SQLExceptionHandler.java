package com.example.plantbusiness.controller;

import com.example.plantbusiness.dto.ErrorDto;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface SQLExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    default ErrorDto p(PSQLException exception) {
        return new ErrorDto(exception.getMessage());
    }
}
