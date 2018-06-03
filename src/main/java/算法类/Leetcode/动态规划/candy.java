package 算法类.Leetcode.动态规划;

import java.util.Arrays;

/** 此题的解法貌似与动态规划并没有关系
 *
 *  There are N children standing in a line. Each child is assigned a rating value.
     You are giving candies to these children subjected to the following requirements:
     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?

     有N个孩子站在一条线上。每个孩子被分配一个等级值。
     你正在给这些孩子们提供糖果，这些孩子需要遵守以下要求：
     每个孩子至少要有一个糖果。
     等级较高的孩子比他们的邻居得到更多的糖果。
     你必须给的最小的糖果是什么？
 */
public class candy {
    public class Solution {
        public int candy(int[] ratings) {
            if (ratings == null || ratings.length ==0) return 0;
            int[] count = new int[ratings.length];
            Arrays.fill(count,1);//用于初始化数组的每一个元素
            //从左到右保证右边比左边的大
            for (int i = 1;i<ratings.length;i++){
                if (ratings[i]>ratings[i-1]){
                    count[i] = count[i-1]+1;
                }
            }
            int sum = 0;
            //从右到左保证左边的比右边的大
            for (int i = ratings.length - 1;i>0;i--){
                sum+=count[i];
                //如果右边的比左边的小并且右边的值大于左边的值
                if (ratings[i]<ratings[i-1]&&count[i]>=count[i-1]){
                    count[i-1]=count[i]+1;
                }
            }
            sum+=count[0];
            return sum;
        }
    }
}
