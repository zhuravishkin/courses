package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListDateDemo {
    public static void main(String[] args) {
        List<ListUser> list = new ArrayList<>();
        list.add(new ListUser(1, "2020-05-25 15:00:10"));
        list.add(new ListUser(1, "2020-05-25 15:00:00"));
        list.add(new ListUser(1, "2020-05-25 15:00:01"));
        list.add(new ListUser(1, "2020-05-25 15:00:20"));
        list.add(new ListUser(1, "2020-05-25 15:00:03"));
        list.sort(Comparator.comparing(ListUser::getTime));
        for (ListUser user : list) {
            System.out.println(user);
        }
    }

    static class ListUser {
        private Integer number;
        private String time;

        public ListUser(Integer number, String time) {
            this.number = number;
            this.time = time;
        }

        public Integer getNumber() {
            return number;
        }

        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "SetUser{" +
                    "number=" + number +
                    ", time=" + time +
                    '}';
        }
    }
}
