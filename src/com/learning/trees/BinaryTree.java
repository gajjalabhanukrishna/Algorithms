package com.learning.trees;

import com.learning.trees.TreeNode;

public class BinaryTree {
    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public boolean add(int value) {

        TreeNode node = new TreeNode(value);

        if(isEmpty()){
            this.root = node;
            return true;
        }

        //Starting from root
        TreeNode  currentNode = root;

        while(currentNode != null){
            TreeNode leftNode = root.getLeftChild();
            TreeNode rightNode = root.getRightChild();

            if(root.getData() > value){
                if(leftNode == null){
                    leftNode = node;
                    currentNode.setLeftChild(leftNode);
                    return true;
                }
                currentNode = leftNode;
            } else {
                if(rightNode == null){
                    rightNode = node;
                    currentNode.setRightChild(rightNode);
                    return true;
                }
                currentNode = rightNode;
            }
        }

        return false;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty()
    {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(TreeNode current){
        if(current == null){
            return;
        }

        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

//    public boolean add(int value) {
//
//        root = recursive_insert(this.root, value);
//        return true;
//    }

    public TreeNode recursive_insert(TreeNode currentNode, int value){
        //Base Case
        if (currentNode == null) {
            return new TreeNode(value);
        }

        if(value < currentNode.getData()){
            currentNode.setLeftChild(recursive_insert(currentNode, value));
        } else if(value > currentNode.getData()){
            currentNode.setRightChild(recursive_insert(currentNode, value));
        } else {
            return currentNode;
        }
        return currentNode;
    }

    //Searches value in BST
    //Either returns the Node with that value or return null
    public TreeNode search(int value) {

        if (isEmpty()) return null; // if tree is empty simply return null

        TreeNode currentNode = this.root;

        while(currentNode != null){
            if(currentNode.getData() == value){
                return currentNode;
            }
            if(currentNode.getData() > value){
                currentNode = currentNode.getLeftChild();
            }else{
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println(value + " Not found in the Tree!");
        return null;

    }

    //3 conditions for delete
    //1.node is leaf node.
    //2.node has 1 child.
    //3.node has 2 children.
    boolean delete(int value, TreeNode currentNode) {

        if (root == null) {
            return false;
        }

        TreeNode parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();

        }

        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node
            //if that leaf node is the root (a tree with just root)
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(null);
                return true;
            }
            else{
                parent.setRightChild(null);
                return true;
            }
        } else if(currentNode.getRightChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{

                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }

        }
        else if(currentNode.getLeftChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }

        }
        else {
            //Find Least Value Node in right-subtree of current Node
            TreeNode leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

    //Helper function to find least value node in right-subtree of currentNode
    private TreeNode findLeastNode(TreeNode currentNode) {

        TreeNode temp = currentNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }

        return temp;

    }

    public boolean isBalanced(TreeNode root){

        int lh;
        int rh;

        if(root == null){
            return  true;
        }

        lh = height(root.leftChild);
        rh = height(root.rightChild);

        if(Math.abs(lh - rh) <= 1 && isBalanced(root.leftChild) && isBalanced(root.rightChild)){
            return true;
        }

        return false;
    }

    public int height(TreeNode root){

        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }


    // A wrapper class used to modify height across
    // recursive calls.
//    class Height {
//        int height = 0;
//    }

//    /* Returns true if binary tree with root as root is height-balanced */
//    boolean isBalanced(Node root, Height height)
//    {
//        /* If tree is empty then return true */
//        if (root == null) {
//            height.height = 0;
//            return true;
//        }
//
//        /* Get heights of left and right sub trees */
//        Height lheight = new Height(), rheight = new Height();
//        boolean l = isBalanced(root.left, lheight);
//        boolean r = isBalanced(root.right, rheight);
//        int lh = lheight.height, rh = rheight.height;
//
//        /* Height of current node is max of heights of
//           left and right subtrees plus 1*/
//        height.height = (lh > rh ? lh : rh) + 1;
//
//        /* If difference between heights of left and right
//           subtrees is more than 2 then this node is not balanced
//           so return 0 */
//        if (abs(lh -rh) >= 2)
//            return false;
//
//        /* If this node is balanced and left and right subtrees
//           are balanced then return true */
//        else
//            return l && r;
//    }


}
