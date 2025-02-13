package com.bootcamp.demo_bc_calculator.codewave;

public enum SysCode {

    OK("000000", "Success."),
    INVILID_OPERATOR("900001", "Invilid operator."),
    ;
    
    private final String code;
    private final String message;

    // private 左 constructor, 唔俾人 new 新既 Code and Message
    private SysCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
