package com.learning.string.dppattern4;

import com.learning.trees.TreeNode;

public class BalancedBinaryTreeT2B {

    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return Math.abs(height(root.leftChild) - height(root.rightChild)) < 2
                && isBalanced(root.leftChild)
                && isBalanced(root.rightChild);
    }

}
