package com.zhuravishkin.courses.javarush;

public class BreakGoTo {
    public static void main(String[] args) {
        first:
        for (int i = 0; i < 3; i++) {
            System.out.print("Прохохд " + i + ": ");
            second:
            for (int j = 0; j < 100; j++) {
                if (j == 10) break second;
                System.out.print(j + " ");
            }
            System.out.println();
        }
//        System.exit(-1);
    }
}
