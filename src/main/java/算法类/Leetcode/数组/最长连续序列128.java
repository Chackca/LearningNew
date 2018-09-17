package 算法类.Leetcode.数组;

import java.util.HashSet;

/**
 * @Author Chackca
 * @Date 2018/9/8 18:40
 * @Description :
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 **/
public class 最长连续序列128 {

    public static void main(String[] args) {
        int[] arr = new int[]{100,4,200,1,3,2};
        System.out.println(result(arr));
    }

    private static int result(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            if (set.remove(arr[i])){
                int current = arr[i];
                int current_next = current+1;
                int current_prev = current-1;
                int sum = 1;
                while(set.remove(current_prev)){
                    sum++;
                    current_prev--;
                }
                while(set.remove(current_next)){
                    sum++;
                    current_next++;
                }
                if (sum>max)
                    max=sum;
            }
        }
        return max;
    }

}
