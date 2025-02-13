package com.bootcamp.demo_bc_calculator.exception;

import com.bootcamp.demo_bc_calculator.codewave.SysCode;

public class OperationException extends RuntimeException{

    private SysCode sysCode;

    public static OperationException of(SysCode sysCode) {
        return new OperationException(sysCode);
    }

    // if private constructor, not allow ppl to new another OperationException
    private OperationException(SysCode sysCode) {
        super(sysCode.getMessage());
        this.sysCode = sysCode;
    }
    
    // if comment this method, will udnerline sysCode
    public SysCode getSysCode() {
        return this.sysCode;
    }

}
