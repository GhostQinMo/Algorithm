package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Black_ghost
 * @title: monotoneIncreasingDigits0738
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-08-11 22:15:05
 * @Description 力扣 738. 单调递增的数字
 **/
@Slf4j
public class monotoneIncreasingDigits0738 {
    /**
     * 先来一波暴力解法
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        //小小的剪枝
        if(n<10){
            return n;
        }
        //从大到小遍历
        for (int i = n; i >0; i--) {
            int temp1=i;
            int flag=0;
            while (temp1!=0){
                //取出每一位
                int temp=temp1%10;
                //判断是否是递增的
                if (temp<temp1%100/10){
                    flag=1;
                    break;
                }
                temp1/=10;
            }
            if(flag==0){
                return i;
            }
        }
        return 0;
    }

    @Test
    //暴力测试
    public  void test01(){
        int n=332;
        int i = monotoneIncreasingDigits(n);
        log.info("i:{}",i);
    }

    /**
     * 解法一：稍微好理解的贪心算法
     * @param n
     * @return
     */
    /*(一定要仔细看清，不然可能不知道下面的flag是干嘛的，为什么还需要flag)
    题目：给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
    （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
    * */
   // 题解：
    /*例如：98，一旦出现strNum[i - 1] > strNum[i]的情况（非单调递增），首先想让strNum[i - 1]--，
    然后strNum[i]给为9，这样这个整数就是89，即小于98的最大的单调递增整数。
    * */
    public int monotoneIncreasingDigits_prefer(int n) {
        // flag用来标记赋值9从哪里开始，也就是最前面的出现的非单调递增的位置开始后面的位置全部要赋值为9，这样才能保证是小于等于N的最大的整数
        //例如： 321  最大的单调递增整数是299,3和2才是最前面的非单调递增的位置
        //例如： 4321 最大的单调递增整数是3999,4和3才是最前面的非单调递增的位置，  这个flag就是用来标记的
        // 设置为flag这个默认值，为了防止第二个for循环在flag没有被赋值的情况下执行
        final String s = String.valueOf(n);
        final char[] chars = s.toCharArray();
        int len=chars.length;
        int flag=len;
        //这里遍历需要重后往前，因为我们需要找到最前面的非单调递增的位置
        for (int i =len-1; i >0; i--) {
            if (chars[i-1]>chars[i]){
                flag=i;
                //在这里必须更新chars[i-1]的值，统一放到for循环之外更新不能通过，我试过了，测试案例333就不能通过
                chars[i-1]--;
            }
        }
        for (int i =flag; i <len; i++) {
            chars[i]='9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    @Test
    public  void test02(){
        int n=333;
        int i = monotoneIncreasingDigits_prefer(n);
        log.info("i:{}",i);
    }

    /**
     * 解法二：力扣上的一个题解，大佬写法
     * @param n
     * @return
     */
    //这个思路很难想到，也不好理解，但是确实很巧妙
    public int monotoneIncreasingDigits_prefer1(int n) {
        //目标就是每次去两位比较，如果前面的大于后面的，就把前面的减一，然后后面的全部变成9
        //i表示取的位置
        int i=1;
        int result=n;
        //i<=result/10表示至少还有两位数没有比较
        while (i<=result/10){
            //提取result中的两位进行比较
            int temp=result/i%100;
            //取下一个连续的两位,这里必须放到if前面，不能放到if后面去
            i*=10;
            //如果前面的大于后面的，就把前面的减一，然后后面的全部变成9
            if (temp/10>temp%10){
                result=result/i*i-1;
            }
        }
        return result;
    }

    @Test
    public  void test03(){
        int n=333;
        int i = monotoneIncreasingDigits_prefer1(n);
        log.info("i:{}",i);
    }
}
