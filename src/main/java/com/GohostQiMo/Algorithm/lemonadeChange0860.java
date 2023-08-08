package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.RetentionPolicy;

/**
 * @author Black_ghost
 * @title: lemonadeChange0860
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-08 10:33:51
 * @Description 力扣 860. 柠檬水找零
 **/
@Slf4j
public class lemonadeChange0860 {
    /**
     * 解题思路：有10元卷优先使用10元卷
     * 有如下三种情况：
     * 情况一：账单是5，直接收下。
     * 情况二：账单是10，消耗一个5，增加一个10
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     *
     * @param bills
     * @return
     */
    //难度：easy
    public boolean lemonadeChange(int[] bills) {
        //定义三个变量分别记录每种纸币的数据
        int five = 0, ten = 0;  //20记录了也没有用，也找不开
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                //来了张20的，先用一张10块的和5块的找回，找不开再用三张5块的试一下
                if (ten != 0 && five != 0) {
                    five--;
                    ten--;
                } else {
                    if (five >= 3) {
                        five = five - 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test01() {
        int[] bills = {5, 5, 5, 10, 20};
        final boolean b = lemonadeChange(bills);
        System.out.println("b = " + b);
    }
}
