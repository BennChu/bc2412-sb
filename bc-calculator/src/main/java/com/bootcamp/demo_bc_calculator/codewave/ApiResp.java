package com.bootcamp.demo_bc_calculator.codewave;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResp {
    private String x;
    private String y;
    private String operation;

}
