package com.zhuravishkin.courses.javarush.interview.hashcodetest;

public class HashCodeDemo {
    public static void main(String[] args) {
        HashCodeDemo hashCodeDemo = new HashCodeDemo();
        System.out.println(hashCodeDemo.hashCode());
        System.out.println(Integer.toHexString(hashCodeDemo.hashCode()));
        System.out.println(hashCodeDemo);
    }
}
