package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Black_ghost
 * @title: levelOrderBM26
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 09:27:12
 * @Description 牛客101  BM26 求二叉树的层序遍历
 **/
@Slf4j
public class levelOrderBM26 {
    @Test
    public void test03(){

    }

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
     * @return int整型ArrayList<ArrayList <>>
     */
    //二叉树的层次遍历  (非递归)
    public ArrayList<ArrayList<Integer>> levelOrder_1(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        //使用队列作为临时容器
        Deque<TreeNode> contianer1=new ArrayDeque<>();
        //初始化容器
        contianer1.push(root);
        while (!contianer1.isEmpty() ){
            //当前节点的数量  （这里容器中的数据一定要放出来，不能写成for (int i = 0; i <contianer1.size() ; i++)）
             int size = contianer1.size();
            //记录当前层的数值
            ArrayList<Integer> temp=new ArrayList<>();
             //遍历当前节点
            for (int i = 0; i < size; i++) {
                TreeNode nextnode = contianer1.pollLast();
                //入队列
                if (nextnode.left!=null){
                    contianer1.push(nextnode.left);
                }
                if (nextnode.right!=null){
                    contianer1.push(nextnode.right);
                }
                temp.add(nextnode.val);
            }
            //遍历完一层，记录结果
            result.add(temp);
        }
        return result;
    }


    /**
     * 二叉树的层次遍历 递归法
     * @param root
     * @return
     */
    //递归
    private ArrayList<ArrayList<Integer>> resul1=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        //边界问题
        if(root==null){
            return new ArrayList<>();
        }
        //这里使用的根节点的深度为1，如果您定义的是0需要考虑逻辑
        recursion(root,1);
        return resul1;
    }

    /**
     *
     * @param node
     * @param depth  当前节点的深度
     */
    //递归函数  怎么确定函数的参数和返回值呢？  我的理解：需要一定的经验和做题？没有其他的办法
    public void recursion(TreeNode node, int depth){
        //终止条件
        if(node==null){
            return;
        }
        //判断是否是当前层的第一个数
        if (resul1.size() <depth){
            //一维数组的长度小于当前深度，是最新层
            ArrayList<Integer> row=new ArrayList<>();
            row.add(node.val);
            //加入放回结果
            resul1.add(row);
        }else {
            //不是最新层
            resul1.get(depth-1).add(node.val);
        }
        //递归下一层 深度加1
        //错误示范
        /*recursion(node.left,++depth);
        recursion(node.right,++depth);*/
        recursion(node.left,depth+1);
        recursion(node.right,depth+1);
    }



    @Test
    public void test01(){
        Deque<Integer> container=new ArrayDeque<>();
        container.add(10);
        container.push(9);
        container.offer(8);
        System.out.println("container.pollLast() = " + container.pollLast());
        System.out.println(container.peekLast());
        System.out.println(container.peekFirst());
        container.pop();
        container.poll();
        System.out.println("fdsa");
    }




}
