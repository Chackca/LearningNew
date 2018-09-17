package 算法类.其他题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 已知正整数数组A，记为{a(1)，a(2)，a(3)，a(4) ...... a(n) ......}，
 * 数组中任一元素大小不超过10000，任意两个元素互不相同。
 * 现在按照以下规则尝试将数组A拆分成若干个(一个或者多个)子数组：
 *
 * A中任意一个元素a(n)必然出现于某个子数组中，且无论是子数组之间还是子数组内元素均不重复出现。
 * 对于任意一个子数组B，记为{b(1)，b(2)，b(3)，b(4) ...... b(n) ......}，B中任一元素b(i)，b(i)在数组A中对应的下标小于b(i+1)在数组A中对应的下标。（如果b(i+1)存在的话）
 * 对于任意一个子数组，数组长度大于等于3，同时其值按照子数组中的顺序构成一个等比或者等差数列。
 * 问题：
 * 求数组A符合以上条件拆分有多少种可能的组合，如不存在则返回0。
 *
 * 以数组 [ 1 2 3 4 5 6 ] 为例其可能的拆分为：
 * [ 1 2 3 ]
 * [ 4 5 6 ]
 *
 * [ 1 2 3 4 5 6 ]
 *
 * [ 1 3 5 ]
 * [ 2 4 6 ]
 * 则其可能的组合数为3.
 *
 * 以数组 [ 1 2 4 3 5 ] 为例则不存在这样的拆分，
 * 其可能的组合数为0.
 */
public class 阿里9月7日数组的子数组未完成 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            List<ArrayList<Integer>> tempList = getSubArrays(arr);
            List<ArrayList<Integer>> list = getSubArraysLength(tempList);
            System.out.println(list);

        }
    }
    /**
     * [[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4],
     * [1, 2, 3, 4], [1, 2, 5], [1, 3, 5], [2, 3, 5],
     * [1, 2, 3, 5], [1, 4, 5], [2, 4, 5], [1, 2, 4, 5],
     * [3, 4, 5], [1, 3, 4, 5], [2, 3, 4, 5], [1, 2, 3, 4, 5],
     * [1, 2, 6], [1, 3, 6], [2, 3, 6], [1, 2, 3, 6], [1, 4, 6],
     * [2, 4, 6], [1, 2, 4, 6], [3, 4, 6], [1, 3, 4, 6], [2, 3, 4, 6],
     * [1, 2, 3, 4, 6], [1, 5, 6], [2, 5, 6], [1, 2, 5, 6],
     * [3, 5, 6], [1, 3, 5, 6], [2, 3, 5, 6], [1, 2, 3, 5, 6],
     * [4, 5, 6], [1, 4, 5, 6], [2, 4, 5, 6], [1, 2, 4, 5, 6],
     * [3, 4, 5, 6], [1, 3, 4, 5, 6], [2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 6]]
     */


    private static List<ArrayList<Integer>> getSubArraysLength(List<ArrayList<Integer>> tempList) {
        List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < tempList.size(); i++) {
            ArrayList<Integer> integers = tempList.get(i);
            if (integers.size()>=3)
                arrays.add(integers);
        }
        return arrays;
    }

    public static List getSubArrays(int[] nums){
        int count = (int)Math.pow(2,nums.length);
        List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<count;i++){
            List<Integer> subarray = new ArrayList<Integer>();
            int temp = i;
            int index = 0;
            while (temp!=0){
                if((temp&1)==1){
                    subarray.add(nums[index]);
                }
                index++;
                temp = temp >>1;
            }
            arrays.add((ArrayList<Integer>) subarray);
        }
        return arrays;
    }
}
