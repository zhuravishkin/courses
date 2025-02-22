package com.zhuravishkin.courses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CoursesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CoursesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
    }
}
