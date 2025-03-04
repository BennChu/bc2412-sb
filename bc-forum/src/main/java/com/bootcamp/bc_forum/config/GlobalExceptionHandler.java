package com.bootcamp.bc_forum.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import com.bootcamp.bc_forum.exception.NoIdException;
import com.bootcamp.bc_forum.model.ErrorResult;

@RestControllerAdvice // Bean
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = NoIdException.class) // {NoIdException.class}
    public ErrorResult handledException(NoIdException e) {
        return new ErrorResult(e.getSysCode().getCode(), e.getSysCode().getMessage());
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ErrorResult handledNumberFormatException(RuntimeException e) {
        return new ErrorResult(SysCode.INVALID_INPUT.getCode(), SysCode.INVALID_INPUT.getMessage());
    }

    // there
    @ExceptionHandler(value = {RestClientException.class, HttpClientErrorException.class, //
        HttpServerErrorException.class, ResourceAccessException.class, HttpStatusCodeException.class})
    public ErrorResult handledRestTemplateException(RuntimeException e) {
        return new ErrorResult(SysCode.RESTTEMPLATE_ERROR.getCode(), SysCode.RESTTEMPLATE_ERROR.getMessage());
    }

    // RestTemplate in Spring to make HTTP requests, various exceptions can occur.
    // Below are some common exceptions associated with RestTemplate and how to handle them.

    // Common Exceptions
    // RestClientException:
    // This is the base class for all exceptions thrown by RestTemplate. 
    // It can be used to catch any client errors.
    // HttpClientErrorException:
    // This exception is thrown when a 4xx (client error) HTTP status code is returned. It contains the response body, headers, and status code.
    // HttpServerErrorException:
    // This is thrown for 5xx (server error) HTTP status codes. Like HttpClientErrorException, it also provides details about the response.
    // ResourceAccessException:
    // This occurs when there is an issue accessing the resource, such as a connection timeout or an unreachable server.
    // HttpStatusCodeException:
    // This is a subclass of RestClientException that provides access to the HTTP status code and response body.



}
