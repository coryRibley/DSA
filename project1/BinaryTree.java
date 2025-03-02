package project1;

import java.util.*;
@SuppressWarnings("unused")

public class BinaryTree implements Tree {
    
    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode (int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    public BinaryTree () {
        root = null;
    }


    public void add(int data) {
        TreeNode node = new TreeNode(data);
        TreeNode currPtr = root;
        while (currPtr != null) {
            if (currPtr.data >= node.data) {
                currPtr = currPtr.left;
            }
            else {
                currPtr = currPtr.right;
            }
        }
        currPtr = node;
    }

    
    public int delete(int data) {
        TreeNode currPtr = root;
        while (currPtr.data != data) {
            if (currPtr.data > data) {
                currPtr = currPtr.left;
            }
            else {
                currPtr = currPtr.right;
            }
        }
        return data;
    }


    public void printInOrder() {

    }


    public void printPreOrder() {

    }


    public void printPostOrder() {

    }

}