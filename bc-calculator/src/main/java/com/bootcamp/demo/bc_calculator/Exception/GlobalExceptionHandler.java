package com.bootcamp.demo.bc_calculator.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.bc_calculator.model.ErrorResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {IllegalStateException.class, BusinessException.class, NumberFormatException.class})
    public ErrorResult handleBsiness(RuntimeException e) {
        return new ErrorResult(e.getMessage());
    }
}
