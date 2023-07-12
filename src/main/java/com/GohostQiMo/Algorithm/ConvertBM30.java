package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: ConvertBM30
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-11 14:45:37
 * @Description 牛客101 BM30 二叉搜索树与双向链表
 **/
@Slf4j
public class ConvertBM30 {
    @Test
    public void test01(){
        TreeNode head=new TreeNode(3);
        head.left=new TreeNode(1);
        head.right=new TreeNode(5);
         TreeNode convert = Convert(head);
        while (convert!=null){
            System.out.print(convert.val);
            convert=convert.right;
        }
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     *
     * @param pRootOfTree
     * @return
     */
    //中序遍历   解题思路：一定要简化问题：不要纠结哪些无畏递归模拟（就是手动一直递归验证，这是不可取的）
    private TreeNode cur_pre=null;
    private TreeNode head=null;
    //注意题目给的是二搜索树
    public TreeNode Convert(TreeNode pRootOfTree) {
        //终止条件
        if (pRootOfTree==null){
            return null ;
        }
        //处理左
        Convert(pRootOfTree.left);
        //处理中
        if (head==null){
            //初始化head,遍历到了最左边，当前搜索树的最小值
            cur_pre=pRootOfTree;
            head=pRootOfTree;
        }else{
            //当前节点与上一节点建立联系  ,这里很难想到啊
            cur_pre.right=pRootOfTree;
            pRootOfTree.left=cur_pre;
            cur_pre=pRootOfTree;
        }
        //处理右
        Convert(pRootOfTree.right);
        return head;
    }
}
