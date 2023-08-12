package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black_ghost
 * @title: combinationSum30216
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-12 21:45:49
 * @Description 力扣  216. 组合总和 III
 **/
@Slf4j
public class combinationSum30216 {
    /**
     * 寻找k个数的和为n的组合
     * @param k
     * @param n
     * @return
     */
    /**
      2 <= k <= 9
     1 <= n <= 60
    */
    //全局变量
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        //剪枝
        int sum=0;
        for (int i = 1; i <=k; i++) {
            sum+=i;
        }
        if (sum>n){
            return result;
        }
        //递归函数
        recursion(1,0,k,n);
        return result;
    }

    /**
     *
     * @param startIndex  开始的位置
     * @param sum   当前的和
     * @param k    总共需要的数字的个数
     * @param n     目标和
     */
    public void recursion(int startIndex,int sum,int k,int n ){
        //回溯三部曲：2.确定终止条件
        if(path.size()==k){
            if (sum==n){
                result.add(new ArrayList<>(path));
            }
            //如果这里没有用return 返回的话，下面一定要用else，不会用重复执行，在这里出现了几次错了
            return ;
        }
        //回溯三部曲：确定遍历顺序 ,这里有一个剪枝的操作，如果数目和目标和多几经不能满足了就直接放弃了
        for (int i = startIndex; i <=9-(k-path.size())+1 ; i++) {
            //这里也需要注意一下：不能sum+=i;不然你后面还需要做减操作
            int temp=sum+i;
            //细节决定成败：剪枝需要在递归之前，可以省掉一些麻烦
            if (sum>n){
                return;
            }
            path.add(i);
            //递归
            recursion(i+1,temp,k,n);
            path.remove(path.size()-1);
        }
    }


    //测试
    @Test
    public void  test01(){
//        List<List<Integer>> lists = combinationSum3(3, 9);
        List<List<Integer>> lists = combinationSum3(3, 7);
        //打印,使用slf4j的日志打印
        for (List<Integer> list : lists) {
            log.info("{}",list);
        }
    }
}
