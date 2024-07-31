package com.zhuravishkin.courses.ya_context;

import java.io.*;
import java.util.Arrays;

public class First_2023_backend {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new StringReader("1 0 2"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        Arrays.sort(parts);
        System.out.println(Arrays.toString(parts));
        writer.write(parts[1]);

        reader.close();
        writer.close();
    }
}
