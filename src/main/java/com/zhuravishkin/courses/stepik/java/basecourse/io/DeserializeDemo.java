package com.zhuravishkin.courses.stepik.java.basecourse.io;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class DeserializeDemo {
    public static void main(String[] args) {
        Dog animal = new Dog("Lion");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            outputStream.writeInt(1);
            outputStream.writeObject(animal);
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(deserializeAnimalArray(byteArrayOutputStream.toByteArray())));
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = inputStream.readInt();
            Animal[] animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) inputStream.readObject();
            }
            return animals;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    static class Dog implements Serializable {
        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }
}
