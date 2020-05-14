package com.learning.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearcTree {

    //Variables
    private TreeNode root;
    //Getter for Root

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //Recursive function to insert a value in BST
    public TreeNode recursive_insert(TreeNode currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new TreeNode(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;


    }

    //Function to call recursive insert
    public boolean add(int value) {

        root = recursive_insert(this.root, value);
        return true;
    }

    //Function to check if Tree is empty or not

    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(TreeNode current) {

        if (current == null) return;


        printTree(current.getLeftChild());
        System.out.print(current.getData() + ",");
        printTree(current.getRightChild());

    }

    public void inorder(TreeNode root, List<Integer> results){

        if(root.getLeftChild() != null){
            inorder(root.getLeftChild(), results);
        }
        results.add(root.getData());
        if(root.getRightChild() != null){
            inorder(root.getRightChild(), results);
        }
    }

    public int findKthMax(TreeNode root, int k) {

        List<Integer> results = new ArrayList<>();

        inorder(root, results);

        // Write - Your - Code
        return results.size() > k ? results.get(results.size() - k) : -1;
    }

    public static void main(String[] args) {

        BinarySearcTree tree = new BinarySearcTree();

        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);

        //List<Integer> results = new ArrayList<>();
        //tree.inorder(tree.root, results);
        System.out.println(tree.findKthMax(tree.root, 3));



    }
}
