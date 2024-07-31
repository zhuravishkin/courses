package com.zhuravishkin.courses.javarush.recursionexample;

import java.io.File;
import java.util.Objects;

public class AllFilesRecursion {
    public static void main(String[] args) {
        printAllFiles(new File("C:\\Program Files\\Java"));
    }

    public static void printAllFiles(File directory) {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                printAllFiles(file);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
