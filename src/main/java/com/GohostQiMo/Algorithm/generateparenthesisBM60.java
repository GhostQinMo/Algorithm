package com.GohostQiMo.Algorithm;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Black_ghost
 * @title: generateparenthesisBM60
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-15 19:20:40
 * @Description 牛客101  BM60 括号生成
 **/
public class generateparenthesisBM60 {
    @Test
    public void tset01(){
        final ArrayList<String> list = generateParenthesis(1);
        list.forEach(System.out::print);

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> result=new ArrayList<>();
    public ArrayList<String> generateParenthesis (int n) {
        if(n==0){
            return result;
        }
        recursion(0,0,n);
        return result;
    }


    /**
     递归函数
     */
    public StringBuilder path=new StringBuilder();
    public void recursion(int left,int right,int n){
        if(path.length()==2*n){
            result.add(path.toString());
            return;
        }

        if(left<n){
            path.append("(");
            recursion(left+1,right,n);
            path.deleteCharAt(path.length()-1);
        }
        if(right<left && right< n){
            path.append(")");
            recursion(left,right+1,n);
            path.deleteCharAt(path.length()-1);
        }
    }
}
