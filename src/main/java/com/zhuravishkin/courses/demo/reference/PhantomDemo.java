package com.zhuravishkin.courses.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomDemo {
    public static void main(String[] args) {
        ReferenceQueue<Integer> queue = new ReferenceQueue<>();

        ArrayList<PhantomReference<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Integer x = Integer.valueOf(i);
            list.add(new PhantomReference<>(x, queue));
        }

        System.gc();

        Reference<? extends Integer> referenceFromQueue;
        while ((referenceFromQueue = queue.poll()) != null) {
            System.out.println(referenceFromQueue.get());
            referenceFromQueue.clear();
        }
    }
}
