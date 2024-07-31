package com.zhuravishkin.courses.javarush.jsonexample;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JsonTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Musya");
        cat.setAge(15);
        cat.setWeight(4);

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, cat);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(writer.toString());

        StringReader reader = new StringReader(writer.toString());

        Cat jsonCat = null;
        try {
            jsonCat = mapper.readValue(reader, Cat.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert jsonCat != null;
        System.out.println(jsonCat.getName() + ", " + jsonCat.getAge() + ", " + jsonCat.getWeight());
    }
}
