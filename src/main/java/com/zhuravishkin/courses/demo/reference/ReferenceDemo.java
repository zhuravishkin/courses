package com.zhuravishkin.courses.demo.reference;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Cat catA = new Cat("Tom");
        Cat catB = new Cat("Bill");

        Reference<Cat> softReference = new SoftReference<>(catA);
        Reference<Cat> weakReference = new WeakReference<>(catB);

        catA = null;
        catB = null;

        while (true) {
            System.out.println(softReference.get());
            System.out.println(weakReference.get());
            System.out.println();
            Thread.sleep(5_000);
            System.gc();
        }
    }
}

@ToString
@AllArgsConstructor
class Cat {
    public final String name;
}
