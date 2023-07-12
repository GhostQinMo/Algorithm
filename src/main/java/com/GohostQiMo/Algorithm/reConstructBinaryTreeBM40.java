package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Black_ghost
 * @title: reConstructBinaryTreeBM40
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 16:22:59
 * @Description 牛客101  BM40 重建二叉树
 **/
@Slf4j
public class reConstructBinaryTreeBM40 {
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
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    //递归 分支法，容易理解，不容易写出来
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        //终止条件
        if(preOrder.length==0 || vinOrder.length==0){
            return null;
        }
        //确定根节点
        TreeNode root=new TreeNode(preOrder[0]);
        //递归时一定要坚持循环不变量原则
        //在中序中找前序
        for (int i = 0; i < vinOrder.length; i++) {
            //找到了
            if (preOrder[0]==vinOrder[i]){
                root.left=reConstructBinaryTree(Arrays.copyOfRange(preOrder,1,i+1),
                        Arrays.copyOfRange(vinOrder,0,i)); //左闭右开
                root.right=reConstructBinaryTree(Arrays.copyOfRange(preOrder,i+1,preOrder.length),
                        Arrays.copyOfRange(vinOrder,i+1,vinOrder.length));
            }
        }
        return root;
    }


    @Test
    public void test01(){
        int[]  result=new int[]{1,3,4,5,6,7};
         int[] ints = Arrays.copyOfRange(result, 0, 0);
        final String s = Arrays.toString(ints);
        System.out.println(s);
        HashMap hashMap=new HashMap();
         Collection values = hashMap.values();

    }
}
