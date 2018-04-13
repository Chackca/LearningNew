package 算法类.剑指offer;

/*
 * 面试题42：连续子数组的最大和

	题目要求：
	输入一个整形数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。
	求所有子数组的和的最大值，要求时间复杂度为o(n)。
	
	解题思路：
	暴力求解，简单直接，但时间复杂度o(n^2)。
	其实这种最值问题，很容易让人想到动态规划。对于数据data[],申请一个数组dp[]，
	定义dp[i]表示以data[i]为末尾元素的子数组和的最大值。dp的初始化及递推公式可表示为
	
	dp[i] =  data[i]            i=0或dp[i-1]<=0
	         dp[i-1]+data[i]    i!=0且dp[i-1]>0
	由于dp[i]仅与dp的前一个状态有关，即在计算dp[i]时，dp[i-2],dp[i-3]......,
	dp[0]对于dp[i]没有影响，因此可以省去dp数组，用一个变量记录当前dp值，
	用另一个变量maxdp记录出现的最大的dp值。如此处理后，时间复杂度为o(n)，空间复杂度为o(1)。
 */
public class 题42连续子数组的最大和 {
	
	
	private static int findGreatestSumOfSumArrays(int[] data) {
		int maxValue = 0;
		int curValue = 0;
		//List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			curValue += data[i];
			if (maxValue<curValue) {
				maxValue = curValue;
			}
			if (curValue <0) {
				curValue = 0;
			}
		}
		return maxValue;
	}
	
	
	public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSumArrays(data));
    }

	
}
