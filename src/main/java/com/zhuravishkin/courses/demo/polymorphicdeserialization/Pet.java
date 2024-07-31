package com.zhuravishkin.courses.demo.polymorphicdeserialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cat.class, name = "cat"),
        @JsonSubTypes.Type(value = Dog.class, name = "dog")
})
public class Pet {
    public String name;
}

@JsonAutoDetect
class Cat extends Pet {
    public int age;
}

@JsonAutoDetect
class Dog extends Pet {
    public int age;
    public String owner;
}
