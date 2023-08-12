package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: minCameraCover0968
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-12 19:35:52
 * @Description 力扣 968. 监控二叉树
 **/
@Slf4j
public class minCameraCover0968 {
    /**
     * @title 节点数据结构
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @title 968. 监控二叉树   题目描述：见力扣原题或代码随想录
     * @param root
     * @return
     */
    //提示：这里看不懂去看代码随想录原题解释
    //目标：
//      1、二叉树的遍历
//      2、如何隔两个节点放一个摄像头
    //这里的分析很难想到的，不要纠结，理解就行
    private int result = 0;

    public int minCameraCover(TreeNode root) {
        //这里还需要判断根节点是否被覆盖，如果没有被覆盖，那么就要放一个摄像头
        if (recursionFun(root) == 0) {
            result++;
        }
        return result;
    }

    /**
     * 递归函数
     *
     * @param root
     * @return
     */
//    0：该节点无覆盖
//    1：本节点有摄像头
//    2：本节点有覆盖
    public int recursionFun(TreeNode root) {
        //终止条件一：如果是空节点，那么就是有覆盖
        if (root == null) {
            return 2;
        }
        //树的后续遍历
        int left = recursionFun(root.left);
        int right = recursionFun(root.right);
        //处理当前节点
        //1. 左右节点都有覆盖，那么当前节点就是无覆盖
        if (left == 2 && right == 2) {
            return 0;
        }
        //2. 左右节点至少有一个无覆盖，那么当前节点作为父节点就是有摄像头
        if (left == 0 || right == 0) {
            ++result;
            return 1;
        }
        //3. 左右节点至少有一个有摄像头，那么当前节点就是有覆盖,第三点必须放到第二点的后面，因为如果父节点被覆盖了，但是子节点没有被覆盖，那么父节点就要放摄像头
        /*if(left==1 || right==1){
            return 2;
        }*/
        //总共就这三种情况，不存在不返回结果的情况，所以第三种可以不需要判断，写成下面这样
        return 2;
    }

    @Test
    public void test01() {
        //生成测试案例
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(0);
        left.left = left1;
        left.right = right1;
        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(0);
        left1.left = left2;
        left1.right = right2;
        //调用方法
        int result = minCameraCover(root);
        //打印结果
        log.info("result:{}", result);
    }

    //感想：思路很难想到，每一个分支很难考虑周到，但是代码写起来很简单
}