package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortJ8 {
    public static class Advertisement {
        private Object content;
        private String name;
        private long initialAmount;
        private int hits;
        private int duration;
        private long amountPerOneDisplaying;

        public Advertisement(String name, long initialAmount, int hits, int duration) {
            this.content = content;
            this.name = name;
            this.initialAmount = initialAmount;
            this.hits = hits;
            this.duration = duration;
            amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }

        public long getAmountPerOneDisplaying() {
            return amountPerOneDisplaying;
        }
    }

    public static void main(String[] args) {
        List<Advertisement> videos = new ArrayList();
        int timeSeconds = 15 * 60;
        List<Advertisement> listA = new ArrayList();
        videos.add(new Advertisement("First video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement("Second video", 100, 10, 15 * 60));
        videos.add(new Advertisement("Third video", 400, 2, 10 * 60));

        videos.sort(Comparator.comparing(Advertisement::getAmountPerOneDisplaying));

        System.out.println("До сортировки:");
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getAmountPerOneDisplaying());
        }

        System.out.println();
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getDuration());
        }

        Collections.reverse(videos);

        System.out.println();
        System.out.println("После сортировки:");
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getAmountPerOneDisplaying());
        }

        System.out.println();
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getDuration());
        }

        System.out.println();
        System.out.println("Стоимость одной секунды:");
        for (Advertisement advertisement : videos) {
            System.out.println((int) ((advertisement.getAmountPerOneDisplaying() * 1.0 / advertisement.getDuration()) * 1000));
        }

        combinations(videos, 0, timeSeconds, listA);

        System.out.println();
        for (Advertisement advertisement : listA) {
            System.out.println(advertisement.getDuration());
        }
    }

    public static void combinations(List<Advertisement> list, int position, int timeSeconds, List<Advertisement> listA) {
        if (timeSeconds <= 0 || position > list.size() - 1) {
            return;
        }
        if (list.get(position).getDuration() <= timeSeconds) {
            listA.add(list.get(position));
            timeSeconds -= list.get(position).getDuration();
        }
        combinations(list, position += 1, timeSeconds, listA);
    }
}
