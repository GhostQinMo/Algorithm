package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author Black_ghost
 * @title: isSymmetricalBM31
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 16:13:56
 * @Description 牛客101  BM31 对称的二叉树
 **/
@Slf4j
public class isSymmetricalBM31 {
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
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetrical_1(TreeNode pRoot) {
        return recursion(pRoot,pRoot);
    }

    /**
     * 递归
     * @param node1
     * @param node2
     * @return
     */
    public boolean recursion(TreeNode node1 ,TreeNode node2){
        //终止条件1
        if (node1==null && node2==null){
            return true;
        }
        //终止条件2
        if (node1==null || node2==null || node1.val!=node2.val){
            return  false;
        }
        //递归
        return recursion(node1.left,node2.right) && recursion(node1.right,node2.left);
    }


    @Test
    public void test09(){
         TreeNode treeNode = new TreeNode(1);
         boolean symmetrical = isSymmetrical(treeNode);
        System.out.println("symmetrical = " + symmetrical);
    }
    /**
     *
     * @param pRoot
     * @return
     */
    //非递归（基于层次遍历）  这一题错误，原因是ArryaDeque中不允许加入null值啊
    public boolean isSymmetrical (TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        //用两个队列保存节点的左右子节点
//        Deque<TreeNode> leftque=new ArrayDeque<>();
//        Deque<TreeNode> rightque=new ArrayDeque<>();
        Deque<TreeNode> leftque=new LinkedList<>();
        Deque<TreeNode> rightque=new LinkedList<>();
        //初始化
        leftque.push(pRoot.left);  //ArrayDeque不允许加入null值
        rightque.push(pRoot.right);
        while (!leftque.isEmpty() && !rightque.isEmpty()){
            //出队列
             TreeNode leftnode = leftque.pollLast();
             TreeNode rightnode=rightque.pollLast();
             //如果都为空算相等
             if(leftnode==null && rightnode==null){
                 continue;
             }
             if(leftnode==null || rightnode==null || leftnode.val!=rightnode.val){
                 return false;
             }
             //入队列
            leftque.push(leftnode.left);
             leftque.push(leftnode.right);
             rightque.push(rightnode.right);
             rightque.push(rightnode.left);
        }
        return true;
    }


    @Test
    public void test01(){
        Deque<Integer> container=new ArrayDeque<>();
        container.add(10);
        container.push(9);
        container.offer(8);
        System.out.println(container.peekLast());
        System.out.println(container.peekFirst());
        container.pop();
        container.poll();
        System.out.println("fdsa");
    }

    @Test
    public void test02(){
        Queue<Integer> container=new LinkedList<>();
        container.add(10);
        container.offer(1);
        System.out.println(container.poll());
    }

}
