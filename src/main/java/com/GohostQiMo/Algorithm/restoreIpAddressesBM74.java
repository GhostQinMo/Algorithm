package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: restoreIpAddressesBM74
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 21:45:29
 * @Description 牛客101  BM74 数字字符串转化成IP地址
 **/
@Slf4j
public class restoreIpAddressesBM74 {
    @Test
    public void test01(){
//        String str="25525522135";
        String str="1111";
        final ArrayList<String> list = restoreIpAddresses(str);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    //最终结果
    private ArrayList<String> result = new ArrayList<String>();
    public ArrayList<String> restoreIpAddresses (String s) {
        dfs(s, 0, 0);
        return result;
    }
    //记录一个合格的ip地址用于回溯
    public StringBuilder path = new StringBuilder();
    //参数意思：题目字符串、开始的索引，加入了几个点
    public void dfs(String s, int sidex, int numpoint) {
        String cur="" ;//当层遍历的ip中的1/4
        //回溯三部曲 2.确定终止条件
        if (numpoint == 4) {
            //如果等于4了，sidex还没有到末尾则剪枝
            if (sidex != s.length()) {
                return ;
            }
            result.add(path.toString());
        } else {
            //单层遍历逻辑 （ip中的一个节点不能超过3位)
            for (int i = sidex; i < sidex + 3 && i < s.length(); i++) {
                cur +=s.charAt(i);
                //转为数字看是否符合作为ip的1/4
                int temp = Integer.valueOf(cur.toString());
                //记录递归前的path，用于回溯
                String str1 = path.toString();
                //小于等于255 大于等于0，除了0之外不能含有前导0
                if (temp <= 255 && (cur.charAt(0) != '0' || cur.length()==1 )) {
                    if (numpoint - 3 != 0) {
                        path = path.append(cur + ".");
                    } else {
                        path = path.append(cur);
                    }
                    //递归
//                    numpoint++;
                    dfs(s, i + 1, numpoint + 1);   //这里numpoint为什么没有需要回溯，因为回溯隐含了
//                    dfs(s, i + 1, numpoint );
                    //回溯
//                    numpoint--;
                    path=new StringBuilder(str1);
                }

            }
        }
    }


    @Test
    public void test03(){

    }
}
