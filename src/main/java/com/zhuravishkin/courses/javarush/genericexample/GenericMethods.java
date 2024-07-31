package com.zhuravishkin.courses.javarush.genericexample;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("John");
        list.add("Smith");
        list.add("Neo");
        for (Object o : list) {
            System.out.println(UtilGeneric.getValue(o, String.class));
        }
        List numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        for (Object o : numbers) {
            System.out.println(UtilGeneric.<Integer>getValue(o));
        }
    }

    public static class UtilGeneric {
        public static <T> T getValue(Object object, Class<T> tClass) {
            return (T) object;
        }

        public static <T> T getValue(Object object) {
            return (T) object;
        }
    }
}
