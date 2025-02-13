package com.bootcamp.demo_bc_calculator.model;

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
