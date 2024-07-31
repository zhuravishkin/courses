package com.zhuravishkin.courses.javarush.interview.queuetest;

import java.util.PriorityQueue;
import java.util.Queue;

public class ObjectTest {
    public static void main(String[] args) {
        String a = "dean";
        String b = new String("dean");
        System.out.println(a == b.intern());
        Queue<String> queue = new PriorityQueue<>();
        queue.add("Dean");
        queue.add("Sam");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
