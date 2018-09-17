package 算法类.Leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author Chackca
 * @Date 2018/9/9 15:19
 * @Description :
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 **/

public class 买卖股票的最佳时机III123 {

    public static void main(String[] args) {
        int[] arr = new int[]{7,6,4,3,1};
        int[] arr2 = new int[]{1,2,3,4,5};
        int[] arr3 = new int[]{3,3,5,0,0,3,1,4};
        int[] arr4 = new int[]{1,2,4,2,5,7,2,4,9,0};
        //System.out.println(maxProfit(arr));
        //System.out.println(maxProfit(arr2));
        //System.out.println(maxProfit(arr3));
        System.out.println(maxProfit(arr4));

        //System.out.println(maxProfit2(arr));
        //System.out.println(maxProfit2(arr2));
    }

    /*public static int maxProfit2(int[] prices) {

    }*/

    public static int maxProfit(int[] prices) {
        if(prices.length == 0 )
            return 0;
        int buy1=Integer.MIN_VALUE;
        int sell1=0;
        int buy2 =Integer.MIN_VALUE;
        int sell2 =0;
        for(int i=0; i<prices.length ;i++){ //计算每次操作后赚钱最多
            buy1 = Math.max(-prices[i],buy1); //第一次买后  因为是花钱，所以赚了 -prices[i]元
            //要选出花钱最少的那天买
            sell1 = Math.max(sell1,buy1 + prices[i]); //第一次卖后  赚的钱
            buy2 = Math.max(buy2,sell1 - prices[i]); //第二次买 ，买后赚的钱数为 第一次赚的 - 第二次买花的
            sell2 = Math.max(sell2,buy2 + prices[i]);// 同第一次卖
        }
        return sell2;
    }
}
