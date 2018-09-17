package 算法类.Leetcode.模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chackca
 * @Date 2018/9/10 10:34
 * @Description :
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 **/
public class 杨辉三角119 {
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row=new ArrayList<Integer>();
        rowIndex++;
        if(rowIndex==0)
            return row;
        row.add(1);
        for(int i=1;i<rowIndex;i++) {
            for(int j=i-1;j>0;j--) {
                row.set(j, row.get(j-1)+row.get(j));
            }
            row.add(1);
        }
        return row;
    }

}
