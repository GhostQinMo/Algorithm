package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: PermutationBM58
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-15 16:46:32
 * @Description 牛客101  BM58 字符串的排列   (这个与有重复数字的全排类一样)
 **/
@Slf4j
public class PermutationBM58 {
    @Test
    public void test01(){
        final ArrayList<String> ab = Permutation("ab");
        ab.forEach(System.out::print);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    //递归+回溯
    public ArrayList<String> result=new   ArrayList<>();
    public ArrayList<String> Permutation (String str) {
        if(str.length()==0){
            result.add(str);
            return result;
        }
        //必须先排序才行
        char[] temp=str.toCharArray();
        Arrays.sort(temp);
        if(str.length()==0){
            return result;
        }
        recursionfun(temp,new boolean[str.length()]);
        return result;
    }
    /**
     String str表示目标字符串
     boolean[] used表示str中哪些字符已经使用过了
     //去重逻辑采用树的层次上去重
     */
    StringBuilder path=new StringBuilder();
    public void  recursionfun(char[] str, boolean[] used){
        //终止条件
        if(path.length()==str.length){
            result.add(path.toString());
        }
        //确定单层遍历逻辑
        for(int i=0;i<str.length;i++){
            //去重，剪枝 （树的层次上去重）
            if(i>0 && str[i-1]==str[i] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                used[i]=true;
                path.append(str[i]);
                recursionfun(str,used);
                used[i]=false;
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
