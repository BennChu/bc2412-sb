package com.bootcamp.bc_forum.exception;

import com.bootcamp.bc_forum.config.SysCode;
import lombok.Getter;

@Getter
public class NoIdException extends RuntimeException{
    private SysCode sysCode;
    
    public NoIdException(SysCode sysCode) {
        super(sysCode.getMessage());
        this.sysCode = sysCode;
    }

    public SysCode getSysCode() {
        return this.sysCode;
    }
}
