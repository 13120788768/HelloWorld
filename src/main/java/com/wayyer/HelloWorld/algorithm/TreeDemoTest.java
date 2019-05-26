package com.wayyer.HelloWorld.algorithm;

/**
 * @Author: wayyer
 * @Description: binary tree node test
 * @Program: HelloWorld
 * @Date: 2019.05.26
 */
public class TreeDemoTest {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.TreeNode node1 = new Tree.TreeNode(122);
        Tree.TreeNode node2 = new Tree.TreeNode(12);
        Tree.TreeNode node3 = new Tree.TreeNode(11);
        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);
        Tree.TreeNode _3Node = tree.find(3);
        Tree.TreeNode _11Node = tree.find(11);
        Tree.TreeNode _122Node = tree.find(122);


        System.out.println("find value 3 " + _3Node);
        System.out.println("find value 11 " + _11Node);
        System.out.println("find value 122 " + _122Node);

        Tree.TreeNode treeNode = tree.root;
        treeNode.preIterator(treeNode);
        System.out.println("--------------");
        treeNode.afterIterator(treeNode);
        System.out.println("--------------");
        treeNode.levelTraverse(treeNode);
        System.out.println("--------------");



    }
}



