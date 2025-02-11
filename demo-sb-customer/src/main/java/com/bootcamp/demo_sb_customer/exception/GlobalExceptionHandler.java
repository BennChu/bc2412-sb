package com.bootcamp.demo_sb_customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo_sb_customer.model.ErrorResult;

@RestControllerAdvice // put it into bean
public class GlobalExceptionHandler extends RuntimeException{
    
    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResult handlerBusiness(RuntimeException e) {
        return new ErrorResult(e.getMessage());
    }
        
}

