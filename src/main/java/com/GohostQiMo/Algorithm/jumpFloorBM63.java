package com.GohostQiMo.Algorithm;

/**
 * @author Black_ghost
 * @title: jumpFloorBM63
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-16 07:34:59
 * @Description 牛客101   BM63 跳台阶
 **/
public class jumpFloorBM63 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param number int整型
     * @return int整型
     */
    public int jumpFloor (int number) {
        if(number==1){
            return 1;
        }
        if(number==2){
            return 2;
        }
        return jumpFloor(number-1)+jumpFloor(number-2);
    }
}
