package com.wayyer.HelloWorld.algorithm;

import java.util.LinkedList;

/**
 * @Author: wayyer
 * @Description: binary tree node
 * @Program: HelloWorld
 * @Date: 2019.05.26
 */
public class Tree{
    TreeNode root;

    public Tree(){}

    public Tree(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + "}";
    }

    public void insert(TreeNode node){
        if(root == null){
            root = node;
        }else {
            TreeNode current = root;
            TreeNode parent;
            while (true){
                parent = current;
                if(parent.value > node.value){
                    current = current.leftNode;
                    if(current == null){
                        parent.leftNode = node;
                        return;
                    }
                }else{
                    current = current.rightNode;
                    if (current == null){
                        parent.rightNode = node;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode find(int value){
        TreeNode current = root;
        while(current.value != value){
            if(value < current.value){
                current = current.leftNode;
            }else{
                current = current.rightNode;
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }


    static class TreeNode {
        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(){}

        public TreeNode(int value){
            this.value = value;
        }

        public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
            this(value);
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        /**
         * 前序遍历：根结点 ---> 左子树 ---> 右子树
         */
        public void preIterator(TreeNode root){
            System.out.println("前序遍历：");
            if(root!=null){
                System.out.println(root.value + " ");
                preIterator(root.leftNode);
                preIterator(root.rightNode);
            }
        }

        /**
         * 中序遍历：左子树---> 根结点 ---> 右子树
         */
        public void midIterator(TreeNode root){
            System.out.println("中序遍历：");
            if(root!=null){
                midIterator(root.leftNode);
                System.out.println(root.value+" ");
                midIterator(root.rightNode);
            }
        }

        /**
         * 后序遍历：左子树 ---> 右子树 ---> 根结点
         */
        public void afterIterator(TreeNode root){
            System.out.println("后序遍历");
            if(root!=null){
                afterIterator(root.rightNode);
                afterIterator(root.leftNode);
                System.out.println(root.value);
            }
        }

        public void levelTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.value+" ");
                if (node.leftNode != null) {
                    queue.offer(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.offer(node.rightNode);
                }
            }
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
}



