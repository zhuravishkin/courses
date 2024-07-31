package com.zhuravishkin.courses.interview;

public class D1StringEqStringBuilder {
    public static void main(String[] args) {
        String string = "hello";
        StringBuilder builder = new StringBuilder("hello");
        StringBuilder builder2 = new StringBuilder("hello");

//        System.out.println(string == builder);
        System.out.println(string.equals(builder));
        System.out.println(builder.equals(builder2));
    }
}
