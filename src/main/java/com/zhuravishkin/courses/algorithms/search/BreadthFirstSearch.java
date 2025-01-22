package com.zhuravishkin.courses.algorithms.search;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        // Создаём граф как список смежности
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Вы", List.of("Алиса", "Боб", "Клэр"));
        graph.put("Боб", List.of("Анюта", "Пегги"));
        graph.put("Алиса", List.of("Том"));
        graph.put("Клэр", List.of("Джонни", "Том"));
        graph.put("Анюта", List.of());
        graph.put("Пегги", List.of());
        graph.put("Том", List.of());
        graph.put("Джонни", List.of());

        // Алгоритм
        String start = "Вы";
        boolean found = bfs(graph, start);

        // Результат
        if (!found) {
            System.out.println("Продавец манго не найден.");
        }
    }

    public static boolean bfs(Map<String, List<String>> graph, String start) {
        Queue<String> searchQueue = new LinkedList<>(graph.get(start)); // Очередь для BFS
        Set<String> searched = new HashSet<>(); // Множество для хранения уже проверенных узлов

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (isMangoSeller(person)) {
                    System.out.println(person + " продаёт манго!");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    public static boolean isMangoSeller(String name) {
        return name.endsWith("м");
    }
}
