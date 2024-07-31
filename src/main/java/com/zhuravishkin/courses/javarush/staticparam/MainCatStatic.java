package com.zhuravishkin.courses.javarush.staticparam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCatStatic {
    public static void main(String[] args) {
        System.out.println(Cat.catCount);
        Cat musya = new Cat("Муся");
        System.out.println(Cat.catCount);
        Cat vasya = new Cat("Вася");
        System.out.println(Cat.catCount);
        Cat nicka = new Cat("Ника");
        System.out.println(Cat.catCount);

        List<Cat> list = new ArrayList<>();
//        list.add(musya);
//        list.add(vasya);
//        list.add(nicka);
        Collections.addAll(list, musya, vasya, nicka);

        /*Проверка исключений*/
//        try {
//            int a = 6 / 0;
//        } catch (NullPointerException e) {
//        } catch (Exception e) {
//            System.out.println("/ by Zero");
//        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }
    }
}
