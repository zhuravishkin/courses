package com.zhuravishkin.courses.demo.polymorphicdeserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class DeserializationDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jefferson";

        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(pets);

        System.out.println(string);

        List list = mapper.readValue(string, List.class);

        for (Object pet : list) {
            System.out.println(pet);
            System.out.println((Cat) pet);
            if (pet instanceof Cat) {
                System.out.println("cat: " + (Cat) pet);
            } else if (pet instanceof Dog) {
                System.out.println("dog: " + (Dog) pet);
            }
        }
    }
}
