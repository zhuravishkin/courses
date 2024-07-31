package com.zhuravishkin.courses.stepik.java.basecourse.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SumOfRealNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
            }
        }
        System.out.write(String.format("%.6f%n", sum).getBytes(StandardCharsets.UTF_8));
        System.out.flush();
    }

    public static void test() {
        String s = "I am -1e3 18 .111\n11bbb";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(inputStream);
        double sum = 0;
        while (scanner.hasNext()) {
            System.out.println();
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
            }
        }
        System.out.printf("%.6f%n", sum);
    }
}
