package com.zhuravishkin.courses.leetcode.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBSTLeavesTest {

    @Test
    void run1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(15);

        assertTrue(ValidateBSTLeaves.run(root, -5, 15));
    }

    @Test
    void run2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(15);

        assertFalse(ValidateBSTLeaves.run(root, 7, 15));
    }

    @Test
    void run3() {
        TreeNode root = new TreeNode();

        assertTrue(ValidateBSTLeaves.run(root, -5, 15));
    }

    @Test
    void run4() {
        TreeNode root = null;

        assertTrue(ValidateBSTLeaves.run(root, -5, 15));
    }
}