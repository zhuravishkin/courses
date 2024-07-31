package com.zhuravishkin.courses.javarush;

public class StaticDynamicTyping {
    public static void main(String[] args) {
        var staticDynamicTyping = new StaticDynamicTyping();
        var sb = new SB();
        staticDynamicTyping.foo(sb);
    }

    void foo(SA sa) {
        sa.get();
    }
}

class SA {
    void get() {
        System.out.println("A");
    }
}

class SB extends SA {
    void get() {
        System.out.println("B");
    }
}
