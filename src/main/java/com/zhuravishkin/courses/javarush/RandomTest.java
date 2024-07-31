package com.zhuravishkin.courses.javarush;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        double d = random.nextDouble();
        System.out.println(random.nextInt());
        System.out.println(d);
        System.out.println((int) (d * 100));
        LocalDateTime start = LocalDateTime.now();
        int count = 0;
        while ((int) (random.nextDouble() * 100) < 99) {
            count++;
        }
        System.out.println(count);
        LocalDateTime finish = LocalDateTime.now();
        System.out.println(finish.getNano() - start.getNano());
        System.out.println(ThreadLocalRandom.current().nextInt(-50, 50));
    }
}
