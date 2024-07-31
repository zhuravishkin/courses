package com.zhuravishkin.courses.stepik.java.basecourse.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EvenPosition {
    public static void main(String[] args) {
        test();
    }

//    public static void test() {
////        String s = "1 2 3 4 5 6 7";
////        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
////        Scanner scanner = new Scanner(inputStream);
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        while (scanner.hasNextInt()) {
//            list.add(scanner.nextInt());
//        }
//        int i = 0;
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            if (i % 2 == 0) {
//                iterator.remove();
//            }
//            i++;
//        }
//        Collections.reverse(list);
//        StringBuilder builder = new StringBuilder();
//        for (Integer in : list) {
//            builder.append(in + " ");
//        }
//        System.out.println(builder);
//    }

    public static void test() {
//        String s = "1 2 3 4 5 6 7";
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
//        Scanner scanner = new Scanner(inputStream);
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextInt()) {
            int e = scanner.nextInt();
            if (i % 2 != 0) {
                list.add(e);
            }
            i++;
        }
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder();
        for (Integer a : list) {
            builder.append(a + " ");
        }
        System.out.println(builder);
    }
}
