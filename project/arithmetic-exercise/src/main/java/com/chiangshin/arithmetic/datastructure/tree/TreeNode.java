package com.chiangshin.arithmetic.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author jx
 * @Date 2021/1/13 0:05
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    private TreeNode getLeftTreeNode() {
        return left;
    }

    private TreeNode getRightNode() {
        return right;
    }

//    先序遍历
//    先访问根节点，然后访问左节点，最后访问右节点(根->左->右)
//    中序遍历
//    先访问左节点，然后访问根节点，最后访问右节点(左->根->右)
//    后序遍历
//    先访问左节点，然后访问右节点，最后访问根节点(左->右->根)
    // 深度优先算法的递归实现
    /**
     * 先序遍历
     * @param rootTreeNode  根节点
     */
    public static void preTraverseBTree(TreeNode rootTreeNode) {

        if (rootTreeNode != null) {

            //访问根节点
            System.out.println(rootTreeNode.getValue());

            //访问左节点
            preTraverseBTree(rootTreeNode.getLeftTreeNode());

            //访问右节点
            preTraverseBTree(rootTreeNode.getRightNode());
        }
    }

    /**
     * 中序遍历
     * @param rootTreeNode  根节点
     */
    public static void inTraverseBTree(TreeNode rootTreeNode) {

        if (rootTreeNode != null) {

            //访问左节点
            inTraverseBTree(rootTreeNode.getLeftTreeNode());

            //访问根节点
            System.out.println(rootTreeNode.getValue());

            //访问右节点
            inTraverseBTree(rootTreeNode.getRightNode());
        }
    }



    // 深度优先算法的循环实现 --先序遍历
    public static void dfsWithStack(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.empty()){
            TreeNode treeNode = stack.pop();

            System.out.println(treeNode.value);

            if(treeNode.right != null){
                stack.push(treeNode.right);
            }

            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }
    // 广度优先算法 先遍历第一层，然后第二层，第三次...
    public static void bfs(TreeNode node){
        if(node == null){
            return;
        }
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(node);
        while (!stack.isEmpty()){
            // 从头拿
            TreeNode treeNode = stack.poll();

            System.out.println(treeNode.value);

            if(treeNode.right != null){
                stack.add(treeNode.right);
            }

            if(treeNode.left != null){
                stack.add(treeNode.left);
            }
        }
    }
}
