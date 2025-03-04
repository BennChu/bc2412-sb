package com.bootcamp.demo_bc_calculator.codewave;

public class BusinessException extends RuntimeException {

    private SysCode sysCode;
    // public BusinessException(String message) {
    //     super(message);
    // }
    
    public BusinessException of(SysCode sysCode) {
        return new BusinessException(sysCode);
    }

     // private 左 constructor
    // bcoz extends RuntimeException, so the message can put in parent
    private BusinessException(SysCode sysCode) {
        super(sysCode.getMessage());
        this.sysCode = sysCode;
    }

    public SysCode getSysCode() {
        return this.sysCode;
    }
}
