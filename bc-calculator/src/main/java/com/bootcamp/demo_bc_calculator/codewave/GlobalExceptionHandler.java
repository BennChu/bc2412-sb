package com.bootcamp.demo_bc_calculator.codewave;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo_bc_calculator.model.ErrorResult;

@RestControllerAdvice//bean
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {IllegalStateException.class, BusinessException.class, NumberFormatException.class})
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResult handleBsiness(RuntimeException e) {
        return new ErrorResult(e.getMessage());
    }
}
