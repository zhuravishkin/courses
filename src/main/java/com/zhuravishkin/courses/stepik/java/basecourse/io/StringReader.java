package com.zhuravishkin.courses.stepik.java.basecourse.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringReader {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[]{48, 49, 50, 51,};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

//    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//        Scanner scanner = new Scanner(inputStream, charset);
//        if (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }
//        return scanner.next();
//    }

//    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//        StringBuilder s = new StringBuilder();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
//        while (inputStreamReader.ready()) {
//            int read = inputStreamReader.read();
//            s.append((char) read);
//        }
//        return s.toString();
//    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return new String(bytes, charset);
    }
}
