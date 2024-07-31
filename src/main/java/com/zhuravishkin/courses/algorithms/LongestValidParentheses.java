package com.zhuravishkin.courses.algorithms;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        run("())()()");
    }

//    public static int run(String s) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (c == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    int currentLength = i - stack.peek();
//                    max = Math.max(max, currentLength);
//                }
//            }
//            System.out.println(stack);
//        }
//
//        return max;
//    }

    public static int run(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        int lastInvalidIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    lastInvalidIndex = i;
                } else {
                    stack.pop();

                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - lastInvalidIndex);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }

        return maxLength;
    }
}
