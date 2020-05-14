package com.learning.trees;

public class TreeNode {
    //Variables
    public  int data;
    public  TreeNode leftChild;
    public  TreeNode rightChild;

    //Constructor
    public TreeNode(int value){
        this.data=value;
        leftChild=null;
        rightChild=null;
    }

    //Getter-Setter
    public TreeNode getLeftChild(){return leftChild;}
    public TreeNode getRightChild(){return rightChild;}
    public int  getData(){return data;}
    public void setData(int value){this.data=value;}
    public void setLeftChild(TreeNode left){this.leftChild=left;}
    public void setRightChild(TreeNode right){this.rightChild=right;}
}
