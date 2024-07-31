package com.zhuravishkin.courses.javarush.interview.forkjointest;

import java.util.concurrent.ForkJoinPool;

public class ProcessorTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.getParallelism());

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
    }
}
