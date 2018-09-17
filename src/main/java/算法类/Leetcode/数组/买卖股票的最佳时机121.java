package 算法类.Leetcode.数组;

/**
 * @Author Chackca
 * @Date 2018/9/9 15:19
 * @Description :
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 **/

public class 买卖股票的最佳时机121 {

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit(arr2));
        System.out.println(maxProfit2(arr));
        System.out.println(maxProfit2(arr2));
    }

    public static int maxProfit2(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        int min=prices[0];
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length==0)
            return 0;

        int maxProfit = 0;
        int lowestBuyPrice = prices[0];
        int sellPrice;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<lowestBuyPrice){
                lowestBuyPrice = prices[i];
            }else{
               sellPrice = prices[i]-lowestBuyPrice;
               if (sellPrice>maxProfit)
                   maxProfit = sellPrice;
            }
        }
        return maxProfit;
    }
}
