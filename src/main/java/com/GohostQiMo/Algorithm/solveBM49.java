package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Black_ghost
 * @title: solveBM49
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 14:34:51
 * @Description 牛客101  BM49 表达式求值
 **/
@Slf4j
public class solveBM49 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int 整型
     */
//    请写一个整数计算器，支持加减乘三种运算和括号。(注意这里只有个 + - * 三种运算)
    //自定义优先级
    public HashMap<Character,Integer>  getpri(){
         HashMap<Character,Integer> pri=new HashMap<>();
         pri.put('-',1);
         pri.put('*',2);
         pri.put('+',1);
         return  pri;
    }
    public int solve (String s) {
         HashMap<Character, Integer> getpri = getpri();
         //初始化容器栈和数值栈（采用语法树的中序遍历求解）
        Stack<Character> ops=new Stack<>();
        Stack<Integer> nums=new Stack<>();
        //为了防止第一个数为负数，先往nums加个0
        nums.push(0);
        //清除s中的空格
         String s1 = s.replaceAll(" ", "");
        //遍历
        for (int i = 0; i < s1.length(); i++) {
            //当遇到的是 ( 时
            if (s1.charAt(i)=='('){
                //直接入ops栈
                ops.push(s1.charAt(i));
                //当遇到的是 ) 时，进行计算
            }else if(s1.charAt(i)==')'){
                //当ops栈中有元素且不是 ( 进行计算
                while (!ops.isEmpty() && ops.peek()!='('){
                    //进行计算
                    cal(ops,nums);
                }
                //弹出)
                ops.pop();
            }else {
                //如果是数字 取值 入栈
                if (Character.isDigit(s1.charAt(i))){
                    int j=i;
                    int sum=0;
                    while (j<s1.length() && Character.isDigit(s1.charAt(j))){
                        //转为数值，持续增加
                        sum=sum*10 + (s1.charAt(j++)-'0');
                    }
                    //入栈
                    nums.push(sum);
                    //计算当前i应该为多少 这里为为什么是j-1 而不是j 原因时，这轮过后i++会自增
                    i=j-1;
                }else {
                    //如果是 符号（+，-，*）
                    //为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为 (0+
                    // （当然也可以不进行这样的预处理，将这个处理逻辑放到循环里去做）
                    if (i> 0 && (s1.charAt(i-1)=='(') ||s1.charAt(i-1)=='-' || s1.charAt(i-1)=='+'){
                        nums.push(0);
                    }
                    //思路判断优先级,只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty() && ops.peek()!='('){
                        //计算
                        if (getpri.get(ops.peek()) >= getpri.get(s1.charAt(i))){
                            cal(ops,nums);
                        }else {
                            //跳出循环
                            break;
                        }
                    }
                    //入栈当前元素
                    ops.push(s1.charAt(i));
                }
            }
        }
        //如果栈中还有元素算完剩余的
        while (!ops.isEmpty() && ops.peek()!= '('){
            cal(ops,nums);
        }
        //返回栈中的元素
        return nums.pop();

    }

    public void cal(Stack<Character> ops,Stack<Integer> nums){
        //如果操作数栈为null nums中小于2个数
        if (nums.isEmpty() || nums.size()<2) return ;
        if (ops.isEmpty()) return ;
        //取数据
         Integer val1 = nums.pop();
         Integer val2 = nums.pop();
         Character pop = ops.pop();
         int temp=0;
        if (pop=='+') temp=val1+val2;
        if (pop=='-') temp=val2-val1;
        if (pop=='*') temp=val1*val2;
        //入栈
        nums.push(temp);

    }



    @Test
    public void test01(){
        String str=new String("3+2*3*4-1");
        final int soplve = solve(str);
        System.out.println("soplve = " + soplve);
    }
}
