package com.zhuravishkin.courses.leetcode.hash_table;

import java.util.*;

/**
 * Соревнования по числу шагов
 * Недавно закончился чемпионат по шагам и тебе нужно подвести его итоги! Дан массив statistics,
 * где statistics[i] = [[id участника, число шагов в i-ый день], ...]. Нужно вернуть id всех участников,
 * которые принимали участие в соревнованиях каждый день и прошли наибольшее число шагов.
 * Результат можно вернуть в любом порядке.
 * Если ни один из участников не принимал участие в соревнованиях каждый день, то нужно вернуть пустой массив.
 * Constraints:
 * len(statistics) >= 1
 */
public class StepCountCompetition {
    public static List<Integer> findCompetitionWinners(List<List<List<Integer>>> statistics) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < statistics.size(); i++) {
            if (i == 0) {
                List<List<Integer>> day0 = statistics.get(i);
                for (List<Integer> member : day0) {
                    map.put(member.get(0), member.get(1));
                }
            } else {
                Set<Integer> set = map.keySet();
                Set<Integer> tmp = new HashSet<>();
                List<List<Integer>> day = statistics.get(i);
                for (List<Integer> member : day) {
                    if (set.contains(member.get(0))) {
                        map.compute(member.get(0), (k, v) -> v + member.get(1));
                        tmp.add(member.get(0));
                    }
                }
                map.keySet().retainAll(tmp);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
