package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NilTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
        String s = "a://a0-ab1&1?-._";
        String path = "/sftp";
        System.out.println(UUID.randomUUID().toString());
        System.out.println(s.length());
        System.out.println(s.replace("-", "").matches("[A-Za-z0-9]+"));
        System.out.println(s.matches("[A-Za-z0-9._-]+"));
        System.out.println(s.matches("[a-zA-Z0-9_.:/&?-]+"));
        System.out.println(path.matches("^/|(/[a-zA-Z0-9_-]+)+$"));
    }
}
