package com.learning.trees;

import com.sun.source.tree.BinaryTree;

public class SerializeDeserializeTree {

    static TreeNode root = null;
    static String result = "";

    public static String serialize(TreeNode root){

        if(root == null){
            return "null,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.getData());
        sb.append(",");

        sb.append(serialize(root.getLeftChild()));
        sb.append(serialize(root.getRightChild()));


        return sb.toString();
    }
    public static TreeNode deSerialize(String s, int index){
        String[] temp = s.split(",");
        return deserializeUsingStaticCounter(temp);
    }

    static int index;
    private static TreeNode deserializeUsingStaticCounter(String[] data) {
        if (index > data.length || data[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[index++]));
        node.setLeftChild(deserializeUsingStaticCounter(data));
        node.setRightChild(deserializeUsingStaticCounter(data));

        return node;
    }

    static String path = "";
    public static String preOrder(TreeNode root){


        if(root != null){
            path += root.getData() + ",";
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }


        return path;
    }


    public static void main(String[] args) {

        TreeNode rootNode = null;

        root = addNode(root, 10);
        addNode(root, 5);
        addNode(root, 20);
        addNode(root, 3);
        addNode(root, 8);
        addNode(root, 7);

        //System.out.println(serialize(root));
        TreeNode treeNode = deSerialize(serialize(root), index);
        System.out.println(treeNode);

    }

    public static TreeNode addNode(TreeNode root, int value){


        if(root == null){
            return new TreeNode(value);
        }

        else if(value < root.getData()){
            root.setLeftChild(addNode(root.getLeftChild(), value));
        } else {
            root.setRightChild(addNode(root.getRightChild(), value));
        }

        return root;
    }
}
