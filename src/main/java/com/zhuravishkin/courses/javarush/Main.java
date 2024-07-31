package com.zhuravishkin.courses.javarush;

public class Main {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s);
        }
    }
}

class MyClass {
    public static void main(String[] args) {
        Main.main(new String[]{"Hello ", "world!"});
    }
}
