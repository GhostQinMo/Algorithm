package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: lowestCommonAncestorBM37
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 10:28:52
 * @Description 牛客101 BM37 二叉搜索树的最近公共祖先
 **/
@Slf4j
public class lowestCommonAncestorBM37 {
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
     * @param p    int整型
     * @param q    int整型
     * @return int整型
     */
    //思路：根据题目要求二叉搜索树没有节点重复，找出两个节点的路径，然后遍历路径找到最后一个相等的值
    //题目要求：两个节点均存在于二叉树中，不需要考虑Null
    public int lowestCommonAncestor_1(TreeNode root, int p, int q) {
        ArrayList<Integer> path = getPath(root, p);
        ArrayList<Integer> path1 = getPath(root, q);
        int result = 0;
        for (int i = 0; i < path.size() && i < path1.size(); i++) {
            //如果相等继续找
            if (path.get(i).equals(path1.get(i))) {
                result = path.get(i);
            } else {
                //不相等就是找到了最后一个相等的值
                break;
            }
        }
        return result;

    }


    //查询目标值的路径
    public ArrayList<Integer> getPath(TreeNode root, int target) {
        ArrayList<Integer> reuslt = new ArrayList<>();
        //注意了这里是while不是if
        while (root.val != target) {
            reuslt.add(root.val);
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        reuslt.add(target);
        return reuslt;
    }


    //递归解法
    /*思路：

    我们也可以利用二叉搜索树的性质：对于某一个节点若是p与q都小于等于这个这个节点值，说明p、q都在这个节点的左子树，
    而最近的公共祖先也一定在这个节点的左子树；若是p与q都大于等于这个节点，说明p、q都在这个节点的右子树，而最近的公共祖先也
    一定在这个节点的右子树。而若是对于某个节点，p与q的值一个大于等于节点值，一个小于等于节点值，说明它们分布在该节点的两边，
    而这个节点就是最近的公共祖先，因此从上到下的其他祖先都将这个两个节点放到同一子树，只有最近公共祖先会将它们放入不同的子树，
    每次进入一个子树又回到刚刚的问题，因此可以使用递归。*/
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        //题目说了两个节点一定在树中，不需要考虑null
        //两个节点在当前节点的两边(这里包括一种特殊情况)，找到了
        if (p<=root.val&& q>=root.val ||(p>=root.val && q<=root.val)){
            return root.val;
        }
        //两个节点在当前节点的同一侧
        if (p<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
