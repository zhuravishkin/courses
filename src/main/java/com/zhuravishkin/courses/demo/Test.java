package com.zhuravishkin.courses.demo;

import lombok.Data;

@Data
public class Test {
    public static void main(String[] args) {
        int a = 0;
        int b = 9;
        double aa = a;
        double bb = b;
        double c = (b - aa) / 2;
        System.out.println(c);
    }
}
