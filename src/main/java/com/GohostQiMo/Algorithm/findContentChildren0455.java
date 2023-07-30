package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: findContentChildren0455
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-30 21:48:24
 * @Description 力扣  0455分发饼干  贪心算法
 **/
@Slf4j
public class findContentChildren0455 {
    /**
     * 关于题目：请自行看力扣，这里我会给出详细的注释
     * @param g
     * @param s
     * @return
     */
    //方法一：暴力求解：饼干安大小排序，每次给孩子一个最临近他胃口值的饼干
    public int findContentChildren_01(int[] g, int[] s) {

        return 1;
    }


    /**
     * 贪心思想： 这里考虑大饼干喂胃口大的孩子 （还可以考虑小饼干喂养胃口小的孩子）
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //结果
        int result=0;
        //边界处理
        if(g.length==0 || s.length==0){
            return result;
        }
        //先排序，因为题目只需要给出最大能喂养几个人，而不是喂养的索引对应位置，排序不会影响结果
        Arrays.sort(g);
        Arrays.sort(s);
        //这里需要注意一下遍历顺序，是先遍历饼干还是先遍历孩子的胃口呢？ 自己想一下就知道了
        int index=s.length-1;
        //先遍历孩子，在遍历饼干
        for(int i=g.length-1;i>=0;i--){
            //大饼干喂养大孩子
            if (index>=0 && s[index]>=g[i]){
                //满足条件
                result++;
                index--;
            }
        }
        return result;
    }

    @Test
    public void test01(){
        final int result = findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        log.debug("result={}",result);
    }
}
