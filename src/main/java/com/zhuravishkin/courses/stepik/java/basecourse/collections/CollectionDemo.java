package com.zhuravishkin.courses.stepik.java.basecourse.collections;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> a = List.of("a", "b", "c");
        List<String> b = List.of("a", "b", "c");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        List<List<String>> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        System.out.println(lists);
        Set<List<String>> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set);

        Collection<?> collection = new ArrayList<>();
        Object object = new Object();
        System.out.println(collection.size());
//        collection.add(object);
//        collection.addAll(Arrays.asList(object));
        System.out.println(collection.contains(object));
        System.out.println(collection.remove(object));
        collection.clear();
    }
}
