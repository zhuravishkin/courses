package com.zhuravishkin.courses.demo.concurrency;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        AtomicLong longValue = new AtomicLong(0);
        Runnable task = () -> longValue.set(new Date().getTime());
        Function<Long, Date> dateConverter = Date::new;
        Consumer<Date> printer = date -> {
            System.out.println(date);
            System.out.flush();
        };

        CompletableFuture.runAsync(task)
                .thenApply(v -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer);
    }
}
