package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: postorderTraversalBM25
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 09:21:02
 * @Description 牛客101  BM25 二叉树的后序遍历
 **/
@Slf4j
public class postorderTraversalBM25 {
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
    //递归（后续），非递归请看preorderTraversalBM23
    public int[] postorderTraversal(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        recursion(root);
        int[] out =new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            out[i]=result.get(i);
        }
        return out;
    }
    //递归函数
    private ArrayList<Integer> result=new ArrayList<>();
    public void  recursion(TreeNode node){
        //终止条件
        if(node==null){
            return ;
        }
        //先左
        recursion(node.left);
        //在右
        recursion(node.right);
        //最后在中间
        result.add(node.val);
    }
}
