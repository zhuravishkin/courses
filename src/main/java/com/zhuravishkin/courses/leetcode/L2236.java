package com.zhuravishkin.courses.leetcode;

public class L2236 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(10, left, right);
        System.out.println(checkTree(root));
    }

    public static boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
