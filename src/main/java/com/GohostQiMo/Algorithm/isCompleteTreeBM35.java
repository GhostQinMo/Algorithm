package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: isCompleteTreeBM35
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 21:08:26
 * @Description 牛客101 BM35 判断是不是完全二叉树
 **/
@Slf4j
public class isCompleteTreeBM35 {
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
     * @return bool布尔型
     */
    //层次遍历变种  （区别：这题与levelOrderBM26树的层次遍历不同的是在于这里只需要输入是否是完全二叉树而不需你按照题目的格式输出）
    public boolean isCompleteTree(TreeNode root) {
        //这里题目指出了节点的范围为1<=n<=100  不需要考虑root=null的情况
        /*if (root==null){
            return false;
        }*/
        //选择容器的时候要根据数据来选择，这里需要存储多个null值，如果容器不允许存储多个null值则需要更换容器
        Deque<TreeNode> container=new LinkedList<>();
        //初始化
        container.push(root);
        boolean flag=true;
        //队列不为空则继续
        while (!container.isEmpty()){
             TreeNode tempnode = container.pollLast();
             //初次遇到
             if (tempnode==null){
                 flag=false;
                 continue;
             }
             //null值以后遇到元素，则不是完全二叉树
             if (!flag){
                 return  false;
             }
             //入队列(层次遍历)
            container.push(tempnode.left);
             container.push(tempnode.right);
        }
        return true;
    }

}
