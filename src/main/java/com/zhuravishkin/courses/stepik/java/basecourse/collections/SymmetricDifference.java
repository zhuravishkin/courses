package com.zhuravishkin.courses.stepik.java.basecourse.collections;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(0, 1, 2));
        System.out.println(symmetricDifference(set1, set2));
    }

//    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
//        Set<T> tmpSet1 = new HashSet<>(set1);
//        Set<T> tmpSet2 = new HashSet<>(set1);
//        tmpSet1.retainAll(set2);
//        tmpSet2.addAll(set2);
//        tmpSet2.removeAll(tmpSet1);
//        return tmpSet2;
//    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> tmpSet1 = new HashSet<>(set1);
        Set<T> tmpSet2 = new HashSet<>(set2);
        tmpSet1.removeIf(o -> tmpSet2.remove(o));
//        tmpSet1.removeIf(tmpSet2::remove);
        tmpSet1.addAll(tmpSet2);
        return tmpSet1;
    }
}
