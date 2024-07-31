package com.zhuravishkin.courses.javarush;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ObjectMapperTest {
    public static void main(String[] args) throws IOException {
        Tuple tuple = new ObjectMapper().readValue("{\"tuple_name\":[\"John\",\"Wick\"],\"tuple_age\":30}", Tuple.class);
        System.out.println(tuple.getName().getClass());
        System.out.println(tuple);
    }

    static class Tuple {
        @JsonProperty("tuple_name")
        private List<String> name;
        @JsonProperty("tuple_age")
        private int age;

        public List<String> getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "name=" + name +
                    ", age=" + age +
                    '}';
        }
    }
}
