package com.zhuravishkin.courses.interview;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Values.A);
    }
}

enum Values {
    A(1),
    B(2),
    C(3);

    Values(int i) {
        System.out.print(i);
    }

    static {
        System.out.print("static");
    }
}
