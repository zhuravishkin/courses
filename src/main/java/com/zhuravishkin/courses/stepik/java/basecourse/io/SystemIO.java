package com.zhuravishkin.courses.stepik.java.basecourse.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SystemIO {
    public static void main(String[] args) throws IOException {
        int first = System.in.read();
        while (first > 0) {
            int second = System.in.read();
            if (first != 13 || second != 10) {
                System.out.write(first);
            }
            first = second;
        }
        System.out.flush();
    }

    public static void test() throws IOException {
        byte[] bytes = {65, 13, 10, 13, 10, 13};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16);
        int first = inputStream.read();
        while (first > 0) {
            int second = inputStream.read();
            if (first != 13 || second != 10) {
                outputStream.write(first);
            }
            first = second;
        }
        byte[] out = outputStream.toByteArray();
        for (byte b : out) {
            System.out.println(b);
        }
        outputStream.flush();
        inputStream.close();
        inputStream.close();
    }
}
