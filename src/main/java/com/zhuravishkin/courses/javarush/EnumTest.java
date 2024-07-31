package com.zhuravishkin.courses.javarush;

public class EnumTest {
    public static void main(String[] args) {
        for (EnumExample enums : EnumExample.values()) {
            System.out.println(enums + " - " + enums.ordinal());
        }
    }

    public enum EnumExample {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
