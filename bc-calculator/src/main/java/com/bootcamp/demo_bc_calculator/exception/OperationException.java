package com.bootcamp.demo_bc_calculator.exception;

import lombok.Getter;

@Getter
public class OperationException extends RuntimeException{

    private String operation;
    private String x;
    private String y;

    public static OperationException of(String operation, String x, String y) {
        return new OperationException(operation, x, y);
    }

    // if private constructor, not allow ppl to new another OperationException
    private OperationException(String operation, String x, String y) {
        this.operation = operation;
        this.x = x;
        this.y = y;
    }
    
    // if comment this method, will udnerline sysCode
     public String getOperation() {
         return this.operation;
     }

     public String getX() {
        return this.x;
     }

     public String getY() {
        return this.y;
     }

}
