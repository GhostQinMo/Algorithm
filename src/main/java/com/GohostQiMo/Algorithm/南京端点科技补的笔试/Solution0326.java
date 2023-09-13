package com.GohostQiMo.Algorithm.南京端点科技补的笔试;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Black_ghost
 * @title: Solution0326
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-09-13 13:17:12
 * @Description 力扣0326  3的幂
 **/

@Slf4j
public class Solution0326 {
    //笔试时自己写的
    public boolean isPowerOfThree_old(int n) {
        long temp = 1;
        while (temp != n && temp < Integer.MAX_VALUE) {
            temp = temp * 3;
        }
        if (temp == n) {
            return true;
        }
        return false;
    }

    /**
     * 看完题解写的
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
