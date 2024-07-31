package com.zhuravishkin.courses.demo.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo1 {
    public static void main(String[] args) {
        User user = new User("Sam");
//        process(() -> user.getName(), s -> user.setName(s));
        process(user::getName, user::setName);
        System.out.println(user);
    }

    public static void process(Supplier<String> supplier, Consumer<String> consumer) {
        consumer.accept(supplier.get() + " Winchester");
    }
}
