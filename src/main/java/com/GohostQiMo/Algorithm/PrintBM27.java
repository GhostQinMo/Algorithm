package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * @author Black_ghost
 * @title: PrintBM27
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 10:37:26
 * @Description 牛客101 BM27 按之字形顺序打印二叉树
 **/
@Slf4j
public class PrintBM27 {

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
     * @return int整型ArrayList<ArrayList <>>
     */
    //层次遍历的变种
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        //使用队列作为临时容器
        Deque<TreeNode> contianer1=new ArrayDeque<>();
        //初始化容器
        contianer1.push(pRoot);
        //添加一个标识标识奇数层还是偶数层,基数层反转
        boolean layer=false;  //(false 表示偶数层，true表示奇数层)
        while (!contianer1.isEmpty() ){
            //当前节点的数量
            int size = contianer1.size();
            //记录当前层的数值
            ArrayList<Integer> temp=new ArrayList<>();
            //遍历当前节点
            for (int i = 0; i < size; i++) {
                TreeNode nextnode=contianer1.pollLast();
                //入队列
                if (nextnode.left!=null){
                    contianer1.push(nextnode.left);
                }
                if (nextnode.right!=null){
                    contianer1.push(nextnode.right);
                }
                temp.add(nextnode.val);
            }
            if (layer){
                Collections.reverse(temp);
            }
            layer=!layer;
            //遍历完一层，记录结果
            result.add(temp);
        }
        return result;
    }
}
