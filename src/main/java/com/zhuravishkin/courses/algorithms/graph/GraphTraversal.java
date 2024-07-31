package com.zhuravishkin.courses.algorithms.graph;

public class GraphTraversal {
    public static void main(String[] params) {
        Node root =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));

        System.out.println("Сумма дерева: " + Node.sumRecursive(root));
        System.out.println("Сумма дерева: " + Node.sumDepth(root));
        System.out.println("Сумма дерева: " + Node.sumBreadth(root));
    }
}
