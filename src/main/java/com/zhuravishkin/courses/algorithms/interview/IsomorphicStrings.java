package com.zhuravishkin.courses.algorithms.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(run("agg", "bdd"));
    }

    public static boolean run(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            char cA = a.charAt(i);
            char cB = b.charAt(i);

            if (!map.containsKey(cA)) {
                if (!set.contains(cB)) {
                    map.put(cA, cB);
                    set.add(cB);
                } else {
                    return false;
                }
            } else {
                char tmp = map.get(cA);
                if (tmp != cB) {
                    return false;
                }
            }
        }

        return true;
    }
}
