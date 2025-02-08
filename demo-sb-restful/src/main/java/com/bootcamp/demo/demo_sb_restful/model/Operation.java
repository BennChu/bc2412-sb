package com.bootcamp.demo.demo_sb_restful.model;

public enum Operation {
    SUM,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,;

    public String lowercase() {
        return this.name().toLowerCase();
    }
}
