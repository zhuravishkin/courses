package com.zhuravishkin.courses.demo;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class Base64UUID {
    public static void main(String[] args) {
        // Генерация UUID
        UUID uuid = UUID.randomUUID();
        System.out.println("Generated UUID: " + uuid);

        // Преобразование UUID в массив байтов
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        // Преобразование байтов в base64
        String base64UUID = Base64.getUrlEncoder().withoutPadding().encodeToString(byteBuffer.array());
        System.out.println("Base64-encoded UUID: " + base64UUID);
    }
}
