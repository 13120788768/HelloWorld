package com.dell.emc.basic.enumexample;

import lombok.Data;

public enum EnumExample {
    GREEN("green"),
    RED("red"),
    BLUE("blue");

    private String name;
    EnumExample(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
