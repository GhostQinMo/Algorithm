package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: lowestCommonAncestorBM38
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 11:29:44
 * @Description 牛客101 BM38 在二叉树中找到两个节点的最近公共祖先
 **/
@Slf4j
public class lowestCommonAncestorBM38 {
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
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    //解法一：层次遍历
    //非递归层次遍历
    //题目保证了二叉树的每个节点的val值不同，值不小于0，节点数>=1;
    public int lowestCommonAncestor_1(TreeNode root, int o1, int o2) {
        //用于存储当前节点的父节点
        HashMap<Integer,Integer> container=new HashMap<>();
        //非递归层次遍历使用队列来解决
        Deque<TreeNode> que=new LinkedList<>();
        //初始容器
        container.put(root.val,-1);
        que.push(root);
        //条件：直到容器中有o1/o2为止
        while (!container.containsKey(o1) || !container.containsKey(o2)){
             TreeNode next = que.pollLast();
             //入队列
             if (next.left!=null){
                 que.push(next.left);
                 container.put(next.left.val,next.val);
             }
             if (next.right!=null){
                 que.push(next.right);
                 container.put(next.right.val,next.val);
             }
        }
        //开始寻找o1的路径
        HashSet<Integer> container1=new HashSet<>();
        //直到找到根节点
        while (container.containsKey(o1)){
            container1.add(o1);
            o1=container.get(o1);
        }
        //开始找最近公共祖先 (如果路径不包含o2则找o2的父节点)
        while (!container1.contains(o2)){
            o2=container.get(o2);
        }
        return o2;
    }


    /**
     * 递归解法
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    //思路；怎么才能将问题简单化呢？ 递归求解：判断两个目标是否在同一个节点上即可
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return helper(root,o1,o2).val;
    }

    /**
     *
     * @return
     */
    //这个思路很难想到，一定需要简化问题
    public TreeNode helper(TreeNode root, int o1, int o2){
        //终止条件
        if(root==null || root.val==o1 || root.val==o2){
            return root;
        }
        //找左边节点，返回两个目标是否在连接同一个节点
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        //回溯
        if (left==null){
            //在右边节点上
            return right;
        }
        if (right==null){
            //在左边节点上
            return left;
        }
        //找到了
        return root;
    }

    @Test
    public void test(){
        TreeNode head=new TreeNode(9);
        head.right=new TreeNode(8);
        head.left=new TreeNode(7);
        head.right.left=new TreeNode(11);
        head.right.right=new TreeNode(10);
//        head.left.left=new TreeNode(12);
         int result = lowestCommonAncestor(head, 11, 10);
        System.out.println("result = " + result);
    }
}
