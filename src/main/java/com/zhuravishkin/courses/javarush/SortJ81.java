package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortJ81 {
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
        int timeSeconds = 3 * 60;
        List<List<Advertisement>> superList = new ArrayList<>();
        List<Advertisement> listA = new ArrayList();

        videos.add(new Advertisement("First video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement("Second video", 100, 10, 15 * 60));
        videos.add(new Advertisement("Third video", 400, 2, 10 * 60));
        videos.add(new Advertisement("Fourth video", 1250, 25, 1 * 60));
        videos.add(new Advertisement("Fifth video", 1250, 25, 2 * 60));

        for (int i = 0; i < videos.size(); i++) {
            listA.add(null);
        }

        System.out.println("До сортировки:");
        System.out.println("Стоимость одного показа:");
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getAmountPerOneDisplaying());
        }

        System.out.println();
        System.out.println("Длительность:");
        for (Advertisement advertisement : videos) {
            System.out.println(advertisement.getDuration());
        }

        System.out.println();
        System.out.println("Стоимость одной секунды:");
        for (Advertisement advertisement : videos) {
            System.out.println((int) ((advertisement.getAmountPerOneDisplaying() * 1.0 / advertisement.getDuration()) * 1000));
        }

        combinations(videos, videos.size() - 1, listA, superList);

        System.out.println();
        System.out.println("Отсеивание:");
        List<List<Advertisement>> superListA = new ArrayList<>();
        for (List<Advertisement> advertisementList : superList) {
            int time = timeSeconds;
            for (Advertisement advertisement : advertisementList) {
                if (advertisement != null) {
                    time -= advertisement.getDuration();
                }
            }
            if (time >= 0) {
                superListA.add(advertisementList);
            }
        }

        System.out.println("Суперлист - стоимость одной секунды");
        for (List<Advertisement> advertisementList : superListA) {
            for (Advertisement advertisement : advertisementList) {
                if (advertisement != null) {
                    System.out.print(advertisement.getAmountPerOneDisplaying() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Суперлист - длительность");
        for (List<Advertisement> advertisementList : superListA) {
            for (Advertisement advertisement : advertisementList) {
                if (advertisement != null) {
                    System.out.print(advertisement.getDuration() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Суперлист - количество показов");
        for (List<Advertisement> advertisementList : superListA) {
            System.out.print(advertisementList.size());
            System.out.println();
        }

        Comparator<List<Advertisement>> comparator = new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                if (Long.compare(getCost(o2), getCost(o1)) == 0) {
                    if (Integer.compare(getDurations(o2), getDurations(o1)) == 0) {
                        return Integer.compare(o1.size(), o2.size());
                    }
                    return Integer.compare(getDurations(o2), getDurations(o1));
                }
                return Long.compare(getCost(o2), getCost(o1));
            }

            public long getCost(List<Advertisement> list) {
                long cost = 0;
                for (Advertisement advertisement : list) {
                    cost += advertisement.getAmountPerOneDisplaying();
                }
                return cost;
            }

            public int getDurations(List<Advertisement> list) {
                int duration = 0;
                for (Advertisement advertisement : list) {
                    duration += advertisement.getDuration();
                }
                return duration;
            }
        };

        superListA.sort(comparator);

        System.out.println();
        System.out.println("Сортировка суперлиста:");
        System.out.println("Суперлист - стоимость одной секунды");
        for (List<Advertisement> advertisementList : superListA) {
            for (Advertisement advertisement : advertisementList) {
                if (advertisement != null) {
                    System.out.print(advertisement.getAmountPerOneDisplaying() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Суперлист - длительность");
        for (List<Advertisement> advertisementList : superListA) {
            for (Advertisement advertisement : advertisementList) {
                if (advertisement != null) {
                    System.out.print(advertisement.getDuration() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Суперлист - количество показов");
        for (List<Advertisement> advertisementList : superListA) {
            System.out.print(advertisementList.size());
            System.out.println();
        }

        for (Advertisement advertisement : superListA.get(0)) {
            System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + " , "
                    + (int) ((advertisement.getAmountPerOneDisplaying() * 1.0 / advertisement.getDuration()) * 1000));
        }
    }

    public static void combinations(List<Advertisement> list, int position, List<Advertisement> listA, List<List<Advertisement>> superList) {
        if (position < 0) {
            ArrayList<Advertisement> listB = new ArrayList<>();
            for (Advertisement advertisement : listA) {
                if (advertisement != null) {
                    listB.add(advertisement);
                }
            }
            if (!listB.isEmpty()) {
                superList.add(listB);
            }
            return;
        }
        combinations(list, position - 1, listA, superList);
        listA.remove(position);
        listA.add(position, list.get(position));
        combinations(list, position - 1, listA, superList);
        listA.remove(position);
        listA.add(position, null);
    }
}
