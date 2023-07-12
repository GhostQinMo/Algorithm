package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: MirrorBM33
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 20:26:31
 * @Description 牛客101 BM33 二叉树的镜像
 **/
@Slf4j
public class MirrorBM33 {
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
     * @return TreeNode类
     */
    //递归思想  分而治之
    public TreeNode Mirror(TreeNode pRoot) {
        //终止条件
        if (pRoot==null){
            return null;
        }
        //递归
        TreeNode temp=pRoot.left;
        pRoot.left=Mirror(pRoot.right);
        pRoot.right=Mirror(temp);
        return pRoot;
    }

}
