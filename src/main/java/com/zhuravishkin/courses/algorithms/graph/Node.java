package com.zhuravishkin.courses.algorithms.graph;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@ToString
@AllArgsConstructor
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public static int sumRecursive(Node root) {
        int summ = root.value;

        System.out.println(root.value);

        if (root.left != null) {
            summ += sumRecursive(root.left);
        }

        if (root.right != null) {
            summ += sumRecursive(root.right);
        }

        return summ;
    }

    public static int sumDepth(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.println(node.value);

            summ += node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return summ;
    }

    public static int sumBreadth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int summ = 0;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            System.out.println(node.value);

            summ = summ + node.value;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return summ;
    }
}
