package 算法类.动态规划;

import java.util.Scanner;

/*
一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
该三角形第n层有n个数字，例如：
第一层有一个数字：5
第二层有两个数字：8 4
第三层有三个数字：3 6 9
第四层有四个数字：7 2 9 5
最优方案是：5 + 8 + 6 + 9 = 28
注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。
状态定义: Fi，j是第i行j列项最大取数和，求第n行Fn，m（0 < m < n）中最大值。
状态转移方程：Fi，j = max{Fi-1,j-1,Fi-1,j}+Ai,j
 */
public class 数塔取数问题 {

    public static void main(String[] args) {
        methodFirst();

    }


    /*
    方法一：从上向下，db数组为二维数组,可以进一步优化为一维数组
     */
    public static void methodFirst(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入总共几行，然后输入每一行的数字，中间用空格隔开");
        int n = in.nextInt();//记录总行数
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = in.nextInt();
        for (int i = 1; i < n; i++) { //当前计算为第i行
            for (int j = 0; j <= i; j++) {//当前计算为i行j列
                int num = in.nextInt();//读取一个输入的值
                if (j == 0)//若当前为i行最左边的数，则只能加上上面一行最左边的数
                    dp[i][j] = dp[i - 1][j] + num;
                else//否则当前不是最左边的数，则其为上一行的左边或者右边加上它之后的最大值
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                max = Math.max(dp[i][j], max);//记录最大值
            }
        }
        System.out.println(max);
    }
}
