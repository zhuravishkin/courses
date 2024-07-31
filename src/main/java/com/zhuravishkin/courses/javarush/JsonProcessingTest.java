package com.zhuravishkin.courses.javarush;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonProcessingTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\"tuple_name\":\"John\",\"tuple_age\":33,\"tuple_weight\":100,\"tuple_country\":\"Moscow\"}";
        LinkedHashMap<String, Object> map = objectMapper.readValue(s, LinkedHashMap.class);
        System.out.println(map);
        List<String> list = List.of("tuple_name", "tuple_age");
        System.out.println(list);
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringList.add(entry.getKey());
        }
        System.out.println(stringList);
        stringList.removeAll(list);
        System.out.println(stringList);
        Tuple tuple = objectMapper.readValue(s, Tuple.class);
        System.out.println(tuple);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Tuple {
        @JsonProperty("tuple_name")
        private String name;
        @JsonProperty("tuple_age")
        private int age;

        @Override
        public String toString() {
            return "JsonTuple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
