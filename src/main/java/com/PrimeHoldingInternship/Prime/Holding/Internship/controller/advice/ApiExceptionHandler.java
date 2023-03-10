package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.advice;

import com.PrimeHoldingInternship.Prime.Holding.Internship.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleNotFoundException(NotFoundException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    private record ErrorMessage(String message) {
    }
}
