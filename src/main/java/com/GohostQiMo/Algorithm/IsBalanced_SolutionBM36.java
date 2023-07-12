package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: IsBalanced_SolutionBM36
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 09:25:16
 * @Description 牛客101 BM36 判断是不是平衡二叉树
 **/
@Slf4j
public class IsBalanced_SolutionBM36 {
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
    //解题思路：判断当前树是不是平衡二叉树（左右节点是不是平衡二叉树&&左右节点高度不大于1）
    public boolean IsBalanced_Solution_1(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        //判断当前树是不是平衡二叉树
        return IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right) && Math.abs(maxDepth(pRoot.left) - maxDepth(pRoot.right)) < 2;
    }

    //高度解决（求解最大深度）
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //当前节点的最大深度等于max(左节点最大深度，右节点最大深度)+1
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    //这里有一个问题：请计算这题的时间和空间复杂度
    //答案：
    // 时间复杂度: 0(n2),其中n为二叉树的节点数，第-个递归遍历_ -叉树所有节点，第二个递归查找深度最坏情况下(二叉树退化为链表)需要遍历二叉树所有节点
    // 空间复杂度：O(n),主要是递归方***占用本地方法栈，而递归层数不会超过n次


    //解题思路：在求左右深度的时候判断左右深度差是否满足平衡二叉树  //约定返回-1则不满足平衡二叉树
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        //如果是平衡二叉树会返回当前树的最高深度
         int depth = depth(pRoot);
         return depth!=-1;
    }

    /**
     * 回溯函数（回溯三要素）（回溯函数的参数和返回值代表什么，终止条件，遍历逻辑）
     * @param node
     * @return
     */
    public int depth(TreeNode node){
        //终止条件
        if(node==null){
            return 0;
        }
        //求左子节点深度
         int leftd = depth(node.left);
        if (leftd==-1){
            //左边已经不满足平衡二叉树的结论了，剪枝操作
            return -1;
        }
         int rightd = depth(node.right);
        if (rightd==-1){
            return -1;
        }
        //向当前节点的父节点是否满足平衡二叉树
        return Math.abs(leftd-rightd)>1 ?-1 : (Math.max(leftd,rightd)+1);

    }
}
