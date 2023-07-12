package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author Black_ghost
 * @title: solveBM41
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 17:08:19
 * @Description BM41 输出二叉树的右视图
 **/
@Slf4j
public class solveBM41 {
    @Test
    public void test01(){
        int[] pre={1,2,4,5,3};
        int[] in={4,2,5,1,3};
         int[] solve = solve(pre, in);
        final String s = Arrays.toString(solve);
        System.out.println(s); // [1,3,5]

    }

    class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    //序列化 加层次遍历

    public int[] solve (int[] preOrder, int[] inOrder) {
        //得到树
         TreeNode treeNode = creteTree(preOrder, inOrder);
         //在从右往左层次遍历
        return  printTreeNode(treeNode);
    }

    /**
     *     //得知中序和前序反序列化（递归）
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode creteTree(int[] preOrder, int[] inOrder){
        //终止条件
        if(preOrder.length==0 || inOrder.length==0){
            return null;
        }
        //初始化
        TreeNode root=new TreeNode(preOrder[0]);
        //在中序中找前序
        for (int i = 0; i < inOrder.length; i++) {
            //找到就递归
            if (inOrder[i]==root.val){
                root.left=creteTree(Arrays.copyOfRange(preOrder,1,i+1),
                        Arrays.copyOfRange(inOrder,0,i));
                root.right=creteTree(Arrays.copyOfRange(preOrder,i+1,preOrder.length),
                        Arrays.copyOfRange(inOrder,i+1,inOrder.length));
            }
        }
        return root;
    }
    //非递归层次遍历

    /**
     *
     * @param root
     * @return
     */
    public int[] printTreeNode(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        //队列
        Deque<TreeNode> deque=new ArrayDeque<>();
        //初始化
        deque.push(root);
        //从右往左
        while (!deque.isEmpty()){
            //temp是上一次的队列中的数目，一定要放出来，不要写到for循环中
            int temp=deque.size();
            for (int i = 0; i < temp; i++) {
                //每一层第一个作为结果放到result中
                TreeNode treeNode = deque.pollLast();
                if (i==0){
                    result.add(treeNode.val);
                }
                //加入队列 (从右往左)
                if(treeNode.right!=null){
                    deque.push(treeNode.right);
                }
                if (treeNode.left!=null){
                    deque.push(treeNode.left);
                }
            }
        }
        int[] out=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
                out[i]=result.get(i);
        }
        return  out;
    }
}
