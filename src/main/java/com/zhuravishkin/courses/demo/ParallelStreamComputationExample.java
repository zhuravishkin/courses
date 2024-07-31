package com.zhuravishkin.courses.demo;

import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Optional;

public class ParallelStreamComputationExample {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        run();
        stopWatch.stop();
        System.out.println("time: " + stopWatch.getTotalTimeMillis());
    }

    private static int compute(int n) {
        try {
            // Симуляция длительного вычисления
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return n * n;
    }

//    private static void run() {
//        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        list.stream()
//                .parallel()
//                .map(ParallelStreamComputationExample::compute)
//                .forEach(System.out::println);
//    }

    private static void run() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Optional<Integer> reduce = list.stream()
                .parallel()
                .reduce((a, b) -> a - b);
        reduce.ifPresent(System.out::println);
//        Integer reduce = list.stream()
//                .parallel()
//                .reduce(0, (a, b) -> a - b);
//        System.out.println(reduce);
    }
}
