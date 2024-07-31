package com.zhuravishkin.courses.javarush;

public class JsonRegEx {
    public static void main(String[] args) {
        String s = "{\"key1\":11,\"key2\":22,\"key3\":33,\"key4\":44}";
        String p = "\"key1\":(\\d+),";
        String o = "\"key2\":(\\d+),";
        System.out.println(s.replaceFirst(p, "").replaceFirst(o, ""));
    }
}
