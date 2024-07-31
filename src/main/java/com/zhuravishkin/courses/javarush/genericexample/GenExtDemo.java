package com.zhuravishkin.courses.javarush.genericexample;

import java.lang.reflect.Field;

public class GenExtDemo {
    public static void main(String[] args) throws IllegalAccessException {
        InnerCalls innerCalls = new InnerCalls();
        innerCalls.setOwner("Sam");
        innerCalls.setNumber(123);
        innerCalls.setRegion("NN");
        Calls.showDetails(innerCalls);
        RoamCalls roamCalls = new RoamCalls();
        roamCalls.setOwner("Dean");
        roamCalls.setNumber(567);
        roamCalls.setCountry("USA");
        Calls.showDetails(roamCalls);
    }
}

class Calls {
    private String owner;
    private int number;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    static <T extends Calls> void showDetails(T t) throws IllegalAccessException {
        Field[] fields = t.getClass().getDeclaredFields();
        Field[] fieldsS = t.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(t));
        }
        for (Field field : fieldsS) {
            System.out.println(field.get(t));
        }
    }
}

class InnerCalls extends Calls {
    private String region;

    public void setRegion(String region) {
        this.region = region;
    }
}

class RoamCalls extends Calls {
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }
}
