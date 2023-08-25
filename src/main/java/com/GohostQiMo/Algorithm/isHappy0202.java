package com.GohostQiMo.Algorithm;

import java.util.HashSet;

/**
 * @author Black_ghost
 * @title: isHappy0202
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-25 22:16:45
 * @Description 力扣  202. 快乐数
 **/
public class isHappy0202 {
    /**
     * 题目：见力扣 202
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> container=new HashSet();
        while(n!=1 && !container.contains(n)){
            container.add(n);
            n=getInt(n);
        }
        return n==1;

    }
    //前进一步，直到取到快乐数
    public  int getInt(int n){
        int result=0;
        while(n>0){
            result+=((n%10)*(n%10));
            //每次执行去除最后一位
            n=n/10;
        }
        return result;
    }
}
