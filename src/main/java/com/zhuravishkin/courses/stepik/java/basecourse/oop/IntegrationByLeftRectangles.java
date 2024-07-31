package com.zhuravishkin.courses.stepik.java.basecourse.oop;

import java.util.function.DoubleUnaryOperator;

public class IntegrationByLeftRectangles {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;
        double h = Math.pow(10, -6);
        double n = (b - a) / h;

        for (double i = a; i <= b; i += h) {
            result += f.applyAsDouble(i);
        }

        return result * h;
    }
}
