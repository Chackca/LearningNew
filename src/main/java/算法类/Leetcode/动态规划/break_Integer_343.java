package 算法类.Leetcode.动态规划;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 例如，给定 n = 2，返回1（2 = 1 + 1）；给定 n = 10，返回36（10 = 3 + 3 + 4）。
 *
 * 注意：你可以假设 n 不小于2且不大于58。
 */
public class break_Integer_343 {

    public static int integerBreak(int n) {
        if (n<=1)
            return n;

        int[] memo = new int[n+1];
        Arrays.fill(memo,1);

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                memo[i] = Math.max(memo[i],Math.max(j*(i-j),j*memo[i-j]));
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

}
