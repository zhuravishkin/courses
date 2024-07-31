package com.zhuravishkin.courses.javarush.listobjectsfromstring;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tuple {
    @JsonProperty("tuple_name")
    private String name;
    @JsonProperty("tuple_age")
    private int age;
}
