package com.bootcamp.demo_sb_customer.codewave;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // put it into bean
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = BusinessException.class)
    // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResp<Void> handlerBusinessException(RuntimeException e) {
        return ApiResp.<Void>builder() //
                .syscode(SysCode.ID_NOT_FOUND) //
                .build();
    }

    @ExceptionHandler(value = NullPointerException.class)
    // @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResp<Void> handlerNullPointerException() { // 冇都可以
        return ApiResp.<Void>builder() //
                .syscode(SysCode.RTE_NPE) //
                .build();
    }



}

