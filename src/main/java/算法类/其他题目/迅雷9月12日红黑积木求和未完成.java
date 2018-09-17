package 算法类.其他题目;

import java.util.Scanner;
/**
 * @Author Chackca
 * @Date 2018/9/12 19:53
 * @Description :
 * 题目描述：
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。
 * 选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
 * 如何挑选才能使17块积木之和最大，最大值是多少？
 *
 * 输入
 * 正数A，负数B
 *
 * A和B绝对值小于10000
 *
 * 输出
 * 积木之和的最大值
 *
 *
 * 样例输入
 * 10 -61
 * 样例输出
 * 28
 **/
public class 迅雷9月12日红黑积木求和未完成 {  //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(getResult(n,m));
        }
    }

    private static int getResult(int n, int m) {
        if (7*n>-m && -6*n>m)
            return n*15+m*2;
        else if ((6*n>-m && -5*n>m) || (5*n>-m && -4*n>m) || (4*n>-m && -3*n>m))
            return n*13+m*4;
        /*else if (5*n>m && -4*n>m)
            return n*11+m*6;
        else if (4*n>m && -3*n>m)
            return n*9+m*8;*/
        else if (3*n>-m && -2*n>m || 2*n>-m && -1*n>m)
            return n*7+m*10;
        /*else if (2*n>m && -1*n>m)
            return n*5+m*12;*/
        return 0;
    }
}
