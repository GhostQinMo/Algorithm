package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Black_ghost
 * @title: MoreThanHalfNum_SolutionBM51
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-13 20:31:23
 * @Description 牛客101  BM51 数组中出现次数超过一半的数字
 **/
@Slf4j
public class MoreThanHalfNum_SolutionBM51 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    //保证数组输入非空，且保证有解
    public int MoreThanHalfNum_Solution (int[] numbers) {
        HashMap<Integer,Integer> container=new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (container.containsKey(numbers[i])){
                container.put(numbers[i],container.get(numbers[i])+1);
            }else {
                container.put(numbers[i],1);
            }
            //检查当前数是否超过当前数组长度的一半
            if (container.get(numbers[i])>numbers.length/2){
                return numbers[i];
            }
        }
        return 0;
    }

    @Test
    public void test(){
        int[] nums ={1,2,3,2,2,2,5,4,2};
        int result=MoreThanHalfNum_Solution(nums);
        System.out.println(result);
    }
}
