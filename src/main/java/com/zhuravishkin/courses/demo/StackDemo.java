package com.zhuravishkin.courses.demo;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        System.out.println(stack);
//        stack.push(-1);
//        System.out.println(stack);
//        stack.push(1);
//        System.out.println(stack);
//        System.out.println(stack.peek());

//        run("((()))");
    }

//    public static int run(String s) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int max = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println("stack: " + stack);
//            System.out.println("i: " + i);
//            char c = s.charAt(i);
//
//            if (c == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                System.out.println("pop");
//
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                    System.out.println("stack push is empty: " + stack);
//                } else {
//                    System.out.println("peek: " + stack.peek());
//                    int currentLength = i - stack.peek();
//                    System.out.println("currentLength: " + currentLength);
//                    max = Math.max(max, currentLength);
//                    System.out.println("max: " + max);
//                }
//            }
//            System.out.println(stack);
//        }
//
//        return max;
//    }

//    public static int run(String s) {
//        Stack<Integer> stack = new Stack<>();
//        int maxLength = 0;
//        int lastInvalidIndex = -1; // Индекс последней некорректной скобки
//
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println("stack: " + stack);
//            System.out.println("i: " + i);
//
//            char c = s.charAt(i);
//
//            if (c == '(') {
//                stack.push(i);
//            } else {
//                if (stack.isEmpty()) {
//                    // Если стек пуст, значит, эта закрывающая скобка не имеет соответствующей открывающей
//                    lastInvalidIndex = i;
//                    System.out.println("lastInvalidIndex: " + lastInvalidIndex);
//                } else {
//                    stack.pop(); // Найдена соответствующая открывающая скобка
//                    System.out.println("pop");
//
//                    if (stack.isEmpty()) {
//                        // Если стек пуст после извлечения, вычисляем длину с последнего некорректного индекса
//                        maxLength = Math.max(maxLength, i - lastInvalidIndex);
//                        System.out.println("maxLength: " + maxLength);
//                    } else {
//                        // Если стек не пуст, вычисляем длину с последнего оставшегося индекса в стеке
//                        maxLength = Math.max(maxLength, i - stack.peek());
//                        System.out.println("maxLength peek: " + maxLength);
//                    }
//                }
//            }
//        }
//
//        return maxLength;
//    }
}
