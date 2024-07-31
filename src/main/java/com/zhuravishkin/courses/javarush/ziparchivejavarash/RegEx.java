package com.zhuravishkin.courses.javarush.ziparchivejavarash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        String getValue;
        String forKey;
        String forValue;
        String after;
        String before;

        Pattern queryPattern = Pattern.compile("get\\s(?<what>[a-zA-Z]+)(\\sfor\\s(?<filter>[a-zA-Z]+)\\s\\=\\s(?<par>(\"(.*?)\")|(\")))?(\\sand date between\\s(?<after>(\"(.*?)\")|(\"))\\sand\\s(?<before>(\"(.*?)\")|(\")))?");

        Matcher matcher = queryPattern.matcher("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"");
        if (matcher.find()) {
            getValue = matcher.group("what");
            forKey = matcher.group("filter");
            forValue = matcher.group("par").substring(1, matcher.group("par").length() - 1);
            after = matcher.group("after");
            before = matcher.group("before");

            System.out.println(getValue + " " + forKey + " " + forValue + " " + after + " " + before);
        }
    }
}
