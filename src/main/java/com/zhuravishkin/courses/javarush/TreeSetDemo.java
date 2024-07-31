package com.zhuravishkin.courses.javarush;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<SetUser> set = new TreeSet(Comparator.comparing(SetUser::getTime).thenComparing(SetUser::getNumber));
        set.add(new SetUser(2, LocalDateTime.parse("2020-05-25T15:00:00")));
        set.add(new SetUser(1, LocalDateTime.parse("2020-05-25T15:00:00")));
        set.add(new SetUser(1, LocalDateTime.parse("2020-05-25T15:00:01")));
        set.add(new SetUser(1, LocalDateTime.parse("2020-05-25T15:00:00")));
        set.add(new SetUser(1, LocalDateTime.parse("2020-05-25T15:00:00")));
        for (SetUser user : set) {
            System.out.println(user);
        }
    }

    static class SetUser {
        private Integer number;
        private LocalDateTime time;

        public SetUser(Integer number, LocalDateTime time) {
            this.number = number;
            this.time = time;
        }

        public Integer getNumber() {
            return number;
        }

        public LocalDateTime getTime() {
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
