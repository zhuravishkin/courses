package com.zhuravishkin.courses.algorithms.greedy;

import java.util.*;

public class SetCovering {
    public static void main(String[] args) {
        // Множество штатов, которые нужно покрыть
        Set<String> statesNeeded = new HashSet<>(Arrays.asList(
                "id", "nv", "ut", "wa", "mt", "or", "ca", "az"
        ));

        // Словарь радиостанций и покрываемых ими штатов
        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "mt", "or")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("ca", "az")));
        stations.put("kfive", new HashSet<>(Arrays.asList("nv", "ut", "az")));

        // Итоговый набор станций
        Set<String> finalStations = new HashSet<>();

        // Алгоритм
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                Set<String> covered = new HashSet<>(station.getValue());
                covered.retainAll(statesNeeded); // Пересечение с оставшимися штатами

                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }

            if (bestStation != null) {
                finalStations.add(bestStation);
                statesNeeded.removeAll(statesCovered); // Убираем покрытые штаты
            }
        }

        // Вывод результата
        System.out.println("Выбранные станции: " + finalStations);
    }
}
