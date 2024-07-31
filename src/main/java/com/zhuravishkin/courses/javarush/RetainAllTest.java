package com.zhuravishkin.courses.javarush;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class RetainAllTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("e");
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("bo");
        strings.add("c");
        list.retainAll(strings);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("e");
        arrayList.add("d");
        arrayList.add("a");
        arrayList.add("f");
        list.retainAll(arrayList);
        System.out.println(list);

        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(arrayList);
        lists.add(strings);
        System.out.println(lists);
        Comparator<List<String>> comparator = (o1, o2) -> Integer.compare(o2.size(), o1.size());
        lists.sort(comparator);
        System.out.println(lists);

        System.out.println(new BigDecimal(0.444).setScale(2, RoundingMode.HALF_UP));

//        Calendar y00 = Calendar.getInstance();
//        y00.setTime(new Date(33134659200000L));
//        System.out.println(new BigDecimal(y00.get(Calendar.YEAR)));

        System.out.println("рейтинг");
        boolean b = false;
        double k = b ? 0.5 : 1;
        System.out.println(k);
        Calendar y0 = Calendar.getInstance();
        y0.setTime(new Date(33134659200000L));
        System.out.println(new BigDecimal((80 * 0.59 * k)/
                (y0.get(Calendar.YEAR) - 3001 + 1)).setScale(2, RoundingMode.HALF_UP).doubleValue());

        System.out.println("рейтинг");
        boolean bo = false;
        double v = bo ? 0.5 : 1;
        System.out.println(v);
        Calendar y00 = Calendar.getInstance();
        y00.setTime(new Date(33134659200000L));
        System.out.println(new BigDecimal((80 * 0.5 * v)/
                (y00.get(Calendar.YEAR) - 3014 + 1)).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }
}
