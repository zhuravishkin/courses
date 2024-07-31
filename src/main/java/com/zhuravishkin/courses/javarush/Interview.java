package com.zhuravishkin.courses.javarush;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Interview {
    public static void main(String[] args) {
        String string = "hello";
        StringBuilder builder = new StringBuilder("hello");
        StringBuilder stringBuilder = new StringBuilder("hello");

//        System.out.println(string == builder);
        System.out.println(string.equals(builder));
        System.out.println(builder.equals(stringBuilder));

//        String substring1 = string.substring(1, 3);
//        String substring2 = string.substring(1, 3);
//        System.out.println(substring1.equals(substring2));

        String string2 = "hello";

        System.out.println(string == string2);
        System.out.println(string.hashCode());
        System.out.println(string2.hashCode());
        System.out.println(string.substring(2).hashCode());

//        try {
////            return;
//            System.exit(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("return");
//        }

//        Получение отрицательного числа
        int e = 6;
        System.out.println(Integer.toBinaryString(e));
        int f = -6;
        System.out.println(Integer.toBinaryString(f));

//        Сдвиг
        int g = 7;
        System.out.println(Integer.toBinaryString(g));
        int h = g << 1;
        System.out.println(Integer.toBinaryString(h));
        System.out.println(h);
        int i = h >> 1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);

        int j = 128; // 1000 0000
        System.out.println(Integer.toBinaryString(j));
        j |= (1<<5); // Устанавливаем в 1 бит 4
        System.out.println(Integer.toBinaryString(j));
        int k = 255; // 1111 1111
        System.out.println(Integer.toBinaryString(k));
        k &= ~(1<<4); // Устанавливаем в 0 бит 4
        System.out.println(Integer.toBinaryString(k));
        System.out.println(j & (1 << 5)); // Получаем значение 4 бита

        File folder = new File("C:\\Users\\User\\Downloads\\");
        System.out.println("isDirectory() - " + folder.isDirectory());
        System.out.println("isFile() - " + folder.isFile());
        System.out.println("getTotalSpace() - " + folder.getTotalSpace());
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            System.out.println(file.getName());
        }

//        Прочитать все строки из файла Files
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get("C:\\Users\\User\\IdeaProjects\\untitled\\src\\mytestpackage\\data\\test.txt"), Charset.defaultCharset());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }

//        Properties
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File("C:\\Users\\User\\IdeaProjects\\untitled\\src\\mytestpackage\\data\\data.properties")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("email"));
        System.out.println(properties.getProperty("size", "10"));

        for (String s : properties.stringPropertyNames()) {
            System.out.println(s + " - " + properties.get(s));
        }

//        RandomAccessFile
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\User\\IdeaProjects\\untitled\\src\\mytestpackage\\data\\test.txt", "rw")) {
            System.out.println(randomAccessFile.readLine());
            randomAccessFile.seek(8);
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.readLine());
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.seek(8);
            randomAccessFile.writeBytes("surprise!");
            randomAccessFile.seek(0);
            System.out.println(randomAccessFile.readLine());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        List list1 = Arrays.asList(1, 2, "a");
//        list1.add(1); Не поддерживается

        List list2 = new ArrayList(10);
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("String");
        arrayList.add(123);
        arrayList.trimToSize();

        List<String> list3 = new ArrayList<>();
        int l = 3;
        for (int m = 0; m < l; m++) {
            list3.add("a");
        }
        System.out.println("list3 size = " + list3.size());
    }
}
