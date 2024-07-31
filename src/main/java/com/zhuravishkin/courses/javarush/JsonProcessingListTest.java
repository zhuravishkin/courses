package com.zhuravishkin.courses.javarush;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonProcessingListTest {
    public static void main(String[] args) throws IOException {
        List<String> list = List.of("tuple_name", "tuple_age");
        System.out.println(list);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "[{\"tuple_name\":\"John\",\"tuple_age\":33,\"tuple_weight\":100},{\"tuple_name\":\"Sam\",\"tuple_age\":30,\"tuple_weight\":80,\"tuple_country\":\"SPB\"}]";
        JSONArray jsonArray = new JSONArray(s);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject);
            LinkedHashMap<String, Object> map = objectMapper.readValue(jsonObject.toString(), LinkedHashMap.class);
            List<String> stringList = new ArrayList<>(map.keySet());
            System.out.println(stringList);
            stringList.removeAll(list);
            System.out.println(stringList);
        }
        List<Tuple> tuples = objectMapper.readValue(s, new TypeReference<>() {});
        System.out.println(tuples);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Tuple {
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
