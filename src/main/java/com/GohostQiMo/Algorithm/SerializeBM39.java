package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Black_ghost
 * @title: SerializeBM39
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-12 15:18:56
 * @Description 牛客101   BM39 序列化二叉树
 **/
@Slf4j
public class SerializeBM39 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 层次序列化（用.表示null，不保存nul的子节点）
     *
     * @param root
     * @return
     */
    //使用非递归层次遍历序列化二叉树
    String Serialize_1(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Deque<TreeNode> container = new LinkedList<>();
        container.push(root);
        while (!container.isEmpty()) {
            TreeNode treeNode = container.pollLast();

            if (treeNode == null) {
                //这里需要注意空指针，如果往队列中放入null的话会造成空指针异常
                result.append("N").append("_");
                continue;
            } else {
                result.append(treeNode.val).append("_");
                container.push(treeNode.left);
                container.push(treeNode.right);
            }
        }
        return result.toString();
    }

    /**
     * @param str
     * @return
     */
    //层次遍历反序列化
    TreeNode Deserialize_1(String str) {
        if (str.equals("")) {
            return null;
        }
        //初始化操作
        String[] s = str.split("_");
         int len = s.length;
        Deque<TreeNode> result = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(s[0]));
        result.add(head);
        //这里为什么是len-1？因为每一次取栈中节点的左右两个节点，一次性取两个，如果是len的话会溢出
        for (int i = 1; i <len-1 ; i+=2) {
             TreeNode treeNode = result.pollLast();
             if (treeNode==null){
                 continue;
             }
            ///从数组中取出当前节点的两个子节点
            if (!s[i].equals("N")){
                 int i1 = Integer.parseInt(s[i]);
                 treeNode.left=new TreeNode(i1);
                 result.push(treeNode.left);
            }
            if (!s[i+1].equals("N")){
                treeNode.right=new TreeNode(Integer.parseInt(s[i+1]));
                result.push(treeNode.right);
            }
        }
        return head;
    }


    @Test
    public void test01() {
        TreeNode head = new TreeNode(9);
        head.right = new TreeNode(8);
        head.left = new TreeNode(7);
        head.right.left = new TreeNode(11);
        head.right.right = new TreeNode(10);
        head.left.left = new TreeNode(12);
        final String serialize = Serialize_1(head);
        System.out.println("serialize = " + serialize);
    }


    // 写完后看的一个题解
    int index = -1;
    /**
     * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
     *
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }
    /**
     * 使用index来设置树节点的val值，递归遍历左节点和右节点，如果值是#则表示是空节点，直接返回
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");//将序列化之后的序列用，分隔符转化为数组
        index++;//索引每次加一
        int len = s.length;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[index].equals("#")) {//不是叶子节点 继续走 是叶子节点出递归
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }

}
