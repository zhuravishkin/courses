package com.zhuravishkin.courses.stepik.java.basecourse.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;

public class IODemo {
    public static void main(String[] args) throws IOException {
        File file;
        Path path;
        byte[] bytes = new byte[]{(byte) 0x33, (byte) 0x45, (byte) 0x01};
        System.out.println(Arrays.toString(bytes));
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println(checkSumOfStream(inputStream));
        System.out.println(Charset.defaultCharset());
        getBytes("Ы");
        getWriter("Ъ");
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        if (inputStream.available() == 0) {
            return sum;
        }
        int read;
        while ((read = inputStream.read()) > 0) {
            sum = Integer.rotateLeft(sum, 1) ^ (byte) read & 0xFF;
        }
        return sum;
    }

    public static void getBytes(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(b);
            System.out.println(Byte.toUnsignedInt(b));
        }
    }

    public static void getWriter(String s) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
//        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write(s);
        writer.flush();
        byte[] out = outputStream.toByteArray();
        for (byte b : out) {
            System.out.println(b);
        }
        writer.close();
    }
}
