package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: solveBM69
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 15:07:30
 * @Description 牛客101  BM69 把数字翻译成字符串
 **/
@Slf4j
public class solveBM69 {
    @Test
    public void test01(){
        final int solve = solve_old("342603");
        System.out.println("solve = " + solve);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    //类似于跳台阶 ，但是拥有更多的条件   // 这种递归思路很难想到
    public int solve_old (String nums) {
        int first = 1, second = 1;
        for(int i = 0;i < nums.length();i++){
            //遇到0不能译码，second清零
            if(nums.charAt(i) == '0'){
                second = 0;
            }
            //更新前两个字符对应的值
            //符合条件则可以译1个或者2个数字
            if(i >= 1 && Integer.parseInt(nums.substring(i-1,i+1)) <= 26){
                second = first + second;
                first = second - first;
            }
            //只能译1个数字
            else{
                first = second;
            }
        }
        return second;
    }


}
