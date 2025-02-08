package com.bootcamp.demo.bc_calculator.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operation {
    SUM("SUM"),
    SUBTRACT("SUBTRACT"),
    MULTIPLY("MULTIPLY"),
    DIVIDE("DIVIDE"),;

    private final String value;


}
