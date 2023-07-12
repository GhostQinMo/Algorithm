package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: maxDepthBM28
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 11:01:20
 * @Description 牛客101  BM28 二叉树的最大深度
 **/
@Slf4j
public class maxDepthBM28 {
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
     *
     * @param root TreeNode类
     * @return int整型
     */
    //递归求解：最大深度=max(左子节点的最大深度，右子节点最大深度）+1;
    public int maxDepth (TreeNode root) {
        //终止条件
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //其他的解法：层次遍历
}
