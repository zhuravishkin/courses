package com.zhuravishkin.courses.algorithms.interview;

/*
Найти сумму всех листьев графе
*/

import lombok.AllArgsConstructor;

public class SumSheetsGraph {
    public static void main(String[] args) {
        Node root =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));

//        Node root =
//                new Node(20,
//                        new Node(7, null, new Node(5)),
//                        new Node(35));

        System.out.println("Сумма листьев дерева: " + run(root));
    }

    public static int run(Node node) {
        System.out.println(node.value);
        int sum = 0;

        if (node == null) {
            return sum;
        }

        if (node.left == null && node.right == null) {
            System.out.println("sheet: " + node.value);
            return node.value;
        }

        if (node.left != null) {
            sum += run(node.left);
        }

        if (node.right != null) {
            sum += run(node.right);
        }

        return sum;
    }
}

@AllArgsConstructor
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
