package com.bootcamp.demo_sb_customer.codewave;

public class BusinessException extends RuntimeException{

    private SysCode syscode;

    // open to ppl, 只可以俾人 call this one
    // 有 sysCode 唔係俾人亂寫
    public static BusinessException of(SysCode sysCode) {
        return new BusinessException(sysCode);
    }

    // private 左 constructor
    // bcoz extends RuntimeException, so the message can put in parent 
    private BusinessException(SysCode sysCode) {
        super(sysCode.getMessage());
        this.syscode = sysCode;
    }

    public SysCode getSysCode() {
        return this.syscode;
    }
    
}
