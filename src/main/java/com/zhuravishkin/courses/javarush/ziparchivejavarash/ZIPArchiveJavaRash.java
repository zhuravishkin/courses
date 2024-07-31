package com.zhuravishkin.courses.javarush.ziparchivejavarash;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIPArchiveJavaRash {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\mytestpackage\\ziparchivejavarash\\result.mp3";
        String zipPath = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\mytestpackage\\ziparchivejavarash\\test.zip";
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
        String newFilePath = "new/" + fileName;

        Map<String, ByteArrayOutputStream> map = new LinkedHashMap<>();
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry zipEntry;
            String name;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                name = zipEntry.getName();
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zipInputStream.read(buffer)) != -1) {
                    arrayOutputStream.write(buffer, 0, count);
                }
                map.put(name, arrayOutputStream);
                zipInputStream.closeEntry();
            }
        }

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath))) {
            boolean isNotDuplicate = true;

            for (Map.Entry<String, ByteArrayOutputStream> entry : map.entrySet()) {
                String name = entry.getKey();
                ZipEntry zipEntry = new ZipEntry(name);
                zipOutputStream.putNextEntry(zipEntry);
                if (name.endsWith(fileName)) {
                    Files.copy(Paths.get(filePath), zipOutputStream);
                    isNotDuplicate = false;
                } else {
                    zipOutputStream.write(entry.getValue().toByteArray());
                }
                zipOutputStream.closeEntry();
            }

            if (isNotDuplicate) {
                ZipEntry zipEntry = new ZipEntry(newFilePath);
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(Paths.get(filePath), zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
    }
}