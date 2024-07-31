package com.zhuravishkin.courses.javarush.jsonexample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bird.class, name = "bird"),
        @JsonSubTypes.Type(value = Dog.class, name = "dog")
})
@JsonAutoDetect
public class Pet {
    public String name;
}

@JsonAutoDetect
class Dog extends Pet {
    public int age;
    public String owner;

    public Dog() {
    }
}

@JsonAutoDetect
class Bird extends Pet {
    public int age;

    public Bird() {
    }
}

@JsonAutoDetect
class Home {
    @JsonDeserialize(as = ArrayList.class)
    public List<Pet> pets = new ArrayList<>();

    public Home() {
    }
}
class jsonPets {
    public static void main(String[] args) throws IOException {
        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 7;
        dog.owner = "Bill";

        Bird bird = new Bird();
        bird.name = "Rio";
        bird.age = 2;

        Home home = new Home();
        home.pets.add(dog);
        home.pets.add(bird);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, home);
        System.out.println(writer);
        StringReader reader = new StringReader(writer.toString());
        Home jsonHome = mapper.readValue(reader, Home.class);

        System.out.println(jsonHome.pets.getClass().getSimpleName() + ": " + jsonHome.pets);
    }
}
