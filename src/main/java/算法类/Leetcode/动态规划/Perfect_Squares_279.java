package 算法类.Leetcode.动态规划;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给出一个正整数n，给出最少的完全平方数，使它们的和=n
 * 完全平方数：1 4 9 16 25......
 * 12=4+4+4
 * 13=9+4
 *
 */
public class Perfect_Squares_279 {

    public static int numSquares(int n) {
        if (n<=0) return -1;
        if (n==1) return 1;

        int[] memo = new int[n+1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            for( int j = 1 ; i-j*j>=0 ; j++ ){
                memo[i] = Math.min( memo[i] , 1 + memo[i-j*j] );
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

}
