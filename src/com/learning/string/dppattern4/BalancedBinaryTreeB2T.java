package com.learning.string.dppattern4;

import com.learning.trees.TreeNode;

public class BalancedBinaryTreeB2T {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.leftChild);
        int right = getHeight(node.rightChild);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
