package 算法类.Leetcode.动态规划;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 思路：可以将本题看做0-1背包的变种
 *
 * 即将数组总和sums求出来，我们只要求能找到若干个数能够填充容量为sums/2的背包就算成功
 */
public class Partition_Equal_Subset_Sum_416 {

    public static boolean canPartition(int[] nums) {
        if (nums == null)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum%2!=0)
            return false;
        int C = sum/2;
        boolean[] memo = new boolean[C+1];

        for (int i = 0; i <= C; i++) {
            if (i == nums[0])
                memo[i] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = C; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j-nums[i]];
            }
        }
        return memo[C];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(arr));
    }
}
