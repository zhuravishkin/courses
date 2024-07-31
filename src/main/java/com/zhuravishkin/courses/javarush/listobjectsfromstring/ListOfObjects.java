package com.zhuravishkin.courses.javarush.listobjectsfromstring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.management.MemoryUsage;
import java.util.List;

public class ListOfObjects {
    public static void main(String[] args) throws IOException {
        List<MemoryUsage> list = new ObjectMapper().readValue("[{\"tuple_name\":\"John\",\"tuple_age\":30},{\"tuple_name\":\"Sam\",\"tuple_age\":35}]", new TypeReference<>() {});
        String string = new ObjectMapper().writeValueAsString(list);
        System.out.println(string);
    }
}
