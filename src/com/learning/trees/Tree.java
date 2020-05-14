package com.learning.trees;

public class Tree {

    // mathod to search for an element in a tree
    public static TreeNode search(int x, TreeNode n) {
        if (n == null || n.getData() == x) //if data of root is x then the element is found
            return n;
        else if (n.getData() > x) // x is greater, so we will search the right subtree
            return search(x, n.getLeftChild());
        else //x is smaller than the data, so we will search the left subtree
            return search(x, n.getRightChild());
    }

    //method to find the minimum value in a tree
    public static TreeNode findMinimum(TreeNode root) {
        if (root == null)
            return null;
        else if (root.getLeftChild() != null) // node with minimum value will have no left child
            return findMinimum(root.getLeftChild()); // left most element will be minimum
        return root;
    }

    // method to insert a new node
    public static TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        else if (x > root.getData()) // x is greater. Should be inserted to right
            root.setRightChild(insert(root.getRightChild(), x));
        else // x is smaller should be inserted to left
            root.setLeftChild(insert(root.getLeftChild(), x));
        return root;
    }

    // method to delete a node
    public static TreeNode delete(TreeNode root, int x) {
        //searching for the item to be deleted
        if (root == null)
            return null;
        if (x > root.getData())
            root.setRightChild(delete(root.getRightChild(), x));
        else if (x < root.getData())
            root.setLeftChild(delete(root.getLeftChild(), x));
        else {
            //No Children
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
                return null;
            }

            //One Child
            else if (root.getLeftChild() == null || root.getRightChild() == null) {
                TreeNode temp;
                if (root.getLeftChild() == null)
                    temp = root.getRightChild();
                else
                    temp = root.getLeftChild();
                root = null;
                return temp;
            }

            //Two Child
            else {
                TreeNode temp = findMinimum(root.getRightChild());
                root.setData(temp.getData());
                root.setRightChild(delete(root.getRightChild(), temp.getData()));
            }
        }
        return root;
    }

    //method for inorder
    public static void inorder(TreeNode root) {
        if (root != null) { // checking if the root is not null
            inorder(root.getLeftChild()); // visiting left child
            System.out.print(" " + root.getData() + " "); // printing data at root
            inorder(root.getRightChild()); // visiting right child
        }
    }

    /*
                   20
                 /    \
                /      \
               5       30
             /   \     /\
            /     \   /  \
           1      15 25  40
                /          \
               /            \
              9             45
            /   \          /
           /     \        /
          7      12      42
    */

    public static void main(String[] args){
        TreeNode root;
        root = new TreeNode(20);
        insert(root,5);
        insert(root,1);
        insert(root,15);
        insert(root,9);
        insert(root,7);
        insert(root,12);
        insert(root,30);
        insert(root,25);
        insert(root,40);
        insert(root, 45);
        insert(root, 42);

        inorder(root);
        System.out.println("");

        root = delete(root, 1);
        /*
                       20
                     /    \
                    /      \
                   5       30
                     \     /\
                      \   /  \
                      15 25   40
                    /           \
                   /             \
                  9              45
                /   \           /
               /     \         /
              7      12       42
        */

        root = delete(root, 40);
        /*
                       20
                     /    \
                    /      \
                   5       30
                     \     /\
                      \   /  \
                      15 25  45
                     /       /
                    /       /
                   9       42
                 /   \
                /     \
               7      12
        */

        root = delete(root, 45);
        /*
                       20
                     /    \
                    /      \
                   5       30
                     \     /\
                      \   /  \
                      15 25  42
                     /
                    /
                   9
                 /   \
                /     \
               7      12
        */
        root = delete(root, 9);
        inorder(root);
        /*
                       20
                     /    \
                    /      \
                   5       30
                     \     /\
                      \   /  \
                      15 25  42
                     /
                    /
                   12
                 /
                /
               7
        */
        System.out.println("");
    }

}
