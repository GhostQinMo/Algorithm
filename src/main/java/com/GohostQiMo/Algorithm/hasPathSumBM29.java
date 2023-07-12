package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: hasPathSumBM29
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 14:14:37
 * @Description BM29 二叉树中和为某一值的路径(一)
 **/
@Slf4j
public class hasPathSumBM29 {
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
     * @param sum  int整型
     * @return bool布尔型
     */
    //递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            //题目的要求：当root==null时也返回false
            return false;
        }
        //如果满足左右节点都为null, 且sum为0时找到路径
        if (root.left==null && root.right==null && sum-root.val==0){
            return true;
        }
        return  (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
    }

}
