package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: mergeTreesBM32
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 20:13:23
 * @Description 牛客101 BM32合并二叉树
 **/
@Slf4j
public class mergeTreesBM32 {
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
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    //递归
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        //初始化：如果两数节点不为空则相加   充分理解分而治之的好处，不需要考虑太多细节（否则你会很烦）
       TreeNode head=new TreeNode(t1.val+t2.val);
        head.left=mergeTrees(t1.left,t2.left);
        head.right=mergeTrees(t1.right,t2.right);
        return head;
    }

}
