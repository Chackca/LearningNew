package 算法类.Leetcode.动态规划;

import java.util.Arrays;

public class Unique_Paths_62 {

    public static int uniquePaths(int m, int n) {
        if (m<1||n<1) return -1;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }

}
