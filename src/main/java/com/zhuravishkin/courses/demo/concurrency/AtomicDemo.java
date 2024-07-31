package com.zhuravishkin.courses.demo.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(5);
        System.out.println(atomicInteger.compareAndSet(5, 6));
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.accumulateAndGet(5, (left, right) -> {
            System.out.println(left + "" + right);
            return left + right;
        }));

        AtomicStampedReference reference = new AtomicStampedReference<>("Hello", 1);
        System.out.println(reference.getReference());
        System.out.println(reference.getStamp());
    }
}
