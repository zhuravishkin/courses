package com.zhuravishkin.courses.algorithms.interview;

public class GenerateParentheses {
    public static void main(String[] args) {
        parens(3);
    }

    public static void generate(String cur, int open, int closed, int n) {
        if (cur.length() == 2 * n) {
            System.out.println(cur);
            return;
        }
        if (open < n) {
            generate(cur + "(", open + 1, closed, n);
        }
        if (closed < open) {
            generate(cur + ")", open, closed + 1, n);
        }
    }

    public static void parens(int n) {
        generate("", 0, 0, n);
    }
}
