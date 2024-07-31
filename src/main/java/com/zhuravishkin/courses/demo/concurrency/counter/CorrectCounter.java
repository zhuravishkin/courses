package com.zhuravishkin.courses.demo.concurrency.counter;

import java.util.concurrent.atomic.AtomicLong;

public class CorrectCounter {
    private AtomicLong count = new AtomicLong();

    public void increment() {
        count.incrementAndGet();
    }

    public long getCount() {
        return count.get();
    }
}
