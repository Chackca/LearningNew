package 算法类.Leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chackca
 * @Date 2018/9/10 9:08
 * @Description :
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
 * Triangle_120
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 **/
public class 三角形最小路径和120 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList();
        list3.add(5);
        list3.add(6);
        list3.add(7);
        ArrayList<Integer> list4 = new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
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
