package 算法类.Leetcode.动态规划;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class House_Robber_198 {

    /**
     * 采用动态规划的方式，自下向上
     */
    public static int rob2(int[] nums) {
        int size = nums.length;
        if (size<=0)
            return -1;
        int[] memo = new int[size];
        Arrays.fill(memo,-1);
        memo[size-1] = nums[size-1];
        for (int i = size-2; i >= 0; i--) {
            for (int j = i; j <size ; j++) {
                memo[i] = Math.max( memo[i], nums[j] + (j+2<size ? memo[j+2] : 0) );
            }
        }
        return memo[0];
    }



    /**
     * 采用记忆化搜索，自顶向下
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return tryRob(nums,0,memo);
    }

    private static int tryRob(int[] nums, int index,int[] memo) {
        if (index >= nums.length)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res,nums[i]+tryRob(nums,i+2,memo));
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,9,3,1};
        System.out.println(rob2(nums));
    }
}
