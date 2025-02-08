package com.bootcamp.demo.demo_sb_restful.exception;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.demo_sb_restful.model.ErrorResult;


@RestControllerAdvice// bean
public class GlobalExceptionHandler {
    
    // spring boot 有 error, 就會有人自然 call this method
    // will handle these two exceptions
    // either of these exceptions is thrown, this method will be called
    @ExceptionHandler(value = {ArithmeticException.class, BusinessException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) 
    // HttpStatus.BAD_REQUEST is 400
    //200 OK
    //HttpStatus.OK
    // why input parameter is RuntimeException
    // because both ArithmeticException and BusinessException are subclasses of RuntimeException
    // This allows the method to handle both exceptions with a single parameter.
    public ErrorResult handleArithmetic(RuntimeException e) { //厡本 ArithmeticException, now RuntimeException
        // This object is serialized into JSON (or another format) and sent back to the client as the response body.
        return new ErrorResult(e.getMessage());
    }

    @ExceptionHandler(value = VincentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResult handleVincentException(VincentException e) {
        return new ErrorResult(e.getMessage());
    }


}
