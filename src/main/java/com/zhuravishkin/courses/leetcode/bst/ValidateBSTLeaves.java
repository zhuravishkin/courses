package com.zhuravishkin.courses.leetcode.bst;

/**
 * Дан корень бинарного дерева поиска root и числа minVal и maxVal.
 * Нужно проверить, что для каждой вершины node в дереве верно: minVal <= node.val <= maxVal
 */
public class ValidateBSTLeaves {
    public static boolean run(TreeNode root, int min, int max) {
        if (root == null) return true;

        int left = getLeftLeastLeaf(root, min);
        int right = getRightMostLeaf(root, max);

        return min <= left && left <= max && right <= max;
    }

    private static int getLeftLeastLeaf(TreeNode node, int min) {
        while (node.left != null) {
            node = node.left;
            if (node.val < min)
                return node.val;
        }
        return node.val;
    }

    private static int getRightMostLeaf(TreeNode node, int max) {
        while (node.right != null) {
            node = node.right;
            if (node.val > max)
                return node.val;
        }
        return node.val;
    }
}
