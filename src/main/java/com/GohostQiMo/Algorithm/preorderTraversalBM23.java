package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Black_ghost
 * @title: preorderTraversalBM23
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-10 21:16:12
 * @Description 牛客101  BM23 二叉树的前序遍历
 **/
@Slf4j
public class preorderTraversalBM23 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    //二叉树的前序遍历
    //递归
    ArrayList<Integer> result = new ArrayList<>();

    public int[] preorderTraversal(TreeNode root) {
        recursion(root);
        //包装返回值
        int[] out=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            out[i]=result.get(i);
        }
        return out;
    }

    //回溯三部曲  1.确定递归函数的参数及返回值的意义
    public void recursion(TreeNode node) {
        //终止条件
        if(node==null){
            return;
        }
        //前序遍历 先加入头节点
        result.add(node.val);
        //遍历左子节点
        recursion(node.left);
        //遍历右子节点
        recursion(node.right);
    }


    //非递归 ，使用栈数据结构
    public int[] preorderTraversal_1(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        //设置辅助栈空间
        Stack<TreeNode> temp=new Stack<>();
        //初始化栈
        if (root==null){
            return new int[0];
        }
        temp.push(root);
        //开始遍历栈 栈空间不为空这遍历
        while (!temp.isEmpty()){
            //前序遍历  弹出当前栈顶节点
             TreeNode headnode = temp.pop();
            result.add(headnode.val);
            //右节点入栈
            if (headnode.right !=null) {
                 temp.push(headnode.right);
            }
            //左节点入栈
            if (headnode.left!=null){
                temp.push(headnode.left);
            }
        }
        int[] out  =new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            out[i]=result.get(i);
        }
        return out;
    }
}
