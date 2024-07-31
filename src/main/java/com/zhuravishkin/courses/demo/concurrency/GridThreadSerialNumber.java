package com.zhuravishkin.courses.demo.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class GridThreadSerialNumber {
//    private int nextSerialNum = 0;
    private AtomicInteger nextSerialNum = new AtomicInteger(0);

    private ThreadLocal<Integer> serialNum = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
//            return nextSerialNum++;
            return nextSerialNum.getAndIncrement();
        }
    };

    public int get() {
        return nextSerialNum.getAndIncrement();
    }
}
