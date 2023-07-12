package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: isValidBSTBM34
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 20:39:42
 * @Description 牛客101 BM34判断是不是二叉搜索树
 **/
@Slf4j
public class isValidBSTBM34 {
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
    //思路一：判断左边是不是搜索树，右边是不是搜索树，但当前节点是不是搜索树 递归法
    //思路二：中序遍历判断元素是不是递增的

    //思路二：递归法  （TODO ：测试存在不通过的案例）
    public boolean isValidBST(TreeNode root) {
        recursion(root);
        return result;
    }
        //这里不能初始化为0，因为树中可能存在负数啊
        private int max =Integer.MIN_VALUE;
        private boolean result=true;
        public void  recursion(TreeNode root){
            if (root==null){
                return;
            }
            //左
            recursion(root.left);
            //中  中序遍历必须是递增的
            if (root.val>max){
               max=root.val;
            }else {
                result=false;
                return;
            }
            //右
            recursion(root.right);
        }
}
