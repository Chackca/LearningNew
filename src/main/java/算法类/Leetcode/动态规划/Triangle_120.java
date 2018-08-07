package 算法类.Leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();    //行数
        if(row==0) return 0;

        int[] res=new int[row+1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了

        for(int i=row-1;i>=0;i--){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();j++){
                res[j]=Math.min(res[j+1],res[j])+list.get(j);//最后一行的最小值就是当前数
            }
        }
        return res[0];
    }

}
