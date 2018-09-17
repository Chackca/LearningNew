package 算法类.Leetcode.模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chackca
 * @Date 2018/9/10 9:38
 * @Description :
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 **/
public class 杨辉三角118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows<=0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> list = new ArrayList();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> lastList = res.get(i - 1-1);
                    list.add(lastList.get(j-1-1)+lastList.get(j-1));
                }
            }
            res.add(list);
        }
        return res;
    }
}
