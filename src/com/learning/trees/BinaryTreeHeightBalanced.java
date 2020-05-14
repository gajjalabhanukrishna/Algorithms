package com.learning.trees;

public class BinaryTreeHeightBalanced {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(1);
        tree.root.leftChild = new TreeNode(2);
        tree.root.rightChild = new TreeNode(3);
        tree.root.leftChild.leftChild = new TreeNode(4);
        tree.root.leftChild.rightChild = new TreeNode(5);
        tree.root.leftChild.leftChild.leftChild = new TreeNode(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

