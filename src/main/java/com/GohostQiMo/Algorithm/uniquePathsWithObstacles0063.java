package com.GohostQiMo.Algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Black_ghost
 * @title: uniquePathsWithObstacles0063
 * @projectName Algorithm
 * @description :616  An unchanging God  Qin_Love
 * @vesion 1.0.0
 * @CreateDate 2023-07-04 19:13:19
 * @Description 力扣0063 不同路径2
 **/

@Slf4j
public class uniquePathsWithObstacles0063 {
    @Test
    public void test01() {
//        int[][] nums={{1},{0}};
        int[][] nums = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
                {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {0, 0},
                {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        final int i = uniquePathsWithObstacles_old(nums);
        System.out.println("i = " + i);
    }

    /**
     * //动态规划5部曲  这个是我自己写的一种方案，测试没有全部通过,具体原因不知道
     *
     * @param obstacleGrid
     * @return
     */
    //本来我想不用其他的内存空间，使用的原来的二维数组做dp数组，但是行不通  找到错误了，细节决定成败
    public int uniquePathsWithObstacles_old(int[][] obstacleGrid) {
        //如果起点和终点遇到了障碍直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        //dp五部曲：1.确定dp[i][j]数组的下标表示什么意思（表示从i,j到0,0的有多少条路径）
        //dp五部曲：3. 初始化递推数组
        //注意：这里会出现重复的初始化操作，00位置会在两个for循环中重复一次初始化
        //初始化第0行
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            //如果是0则存在一条路径
            if (obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = 1;
            } else {
                //如果遇到了第一个障碍，后面所有的全部为0
                for (int j = i; j < obstacleGrid[0].length; j++) {
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
        }
        //初始化第0列
        for (int i = 1; i < obstacleGrid.length; i++) {
            //如果是0则存在一条路径
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                for (int j = i; j < obstacleGrid.length; j++) {
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
        }
        //dp五部曲： 2.确定递推公式
        //d五部曲：4.确定遍历顺序
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                /*if (obstacleGrid[i][j]==0){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }else {
                    //如果碰到障碍物则需要把当前的障碍物置为0;
                    obstacleGrid[i][j]=0;
                }*/
                obstacleGrid[i][j] = obstacleGrid[i][j] == 0 ? obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1] : 0;
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        //这里的obstacleGrid[i][0] == 0  条件可以终止遇到障碍物之后的情况
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}




