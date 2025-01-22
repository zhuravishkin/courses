package com.zhuravishkin.courses.algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        // Граф как карта
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("Старт", Map.of("A", 6, "B", 2));
        graph.put("A", Map.of("Конец", 1));
        graph.put("B", Map.of("A", 3, "Конец", 5));
        graph.put("Конец", Map.of());

        // Стоимость узлов
        Map<String, Integer> costs = new HashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("Конец", Integer.MAX_VALUE);

        // Родительские узлы
        Map<String, String> parents = new HashMap<>();
        parents.put("A", "Старт");
        parents.put("B", "Старт");
        parents.put("Конец", null);

        // Множество обработанных узлов
        Set<String> processed = new HashSet<>();

        // Алгоритм
        String node = findLowestCostNode(costs, processed);
        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                int newCost = cost + neighbor.getValue();
                if (newCost < costs.get(neighbor.getKey())) {
                    costs.put(neighbor.getKey(), newCost);
                    parents.put(neighbor.getKey(), node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }

        // Результаты
        System.out.println("Минимальные стоимости: " + costs);
        System.out.println("Родители: " + parents);
    }

    private static String findLowestCostNode(Map<String, Integer> costs, Set<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;
        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            if (!processed.contains(entry.getKey()) && entry.getValue() < lowestCost) {
                lowestCost = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }
}
