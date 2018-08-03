package 算法类.Leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
 [1,2,2],
 [5]
 ]
 */
public class Combinations_Sum_40 {

    private static List<List<Integer>> res = new ArrayList<>();
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null)
                return res;
            Arrays.sort(candidates);
            LinkedList<Integer> list = new LinkedList();
            find(candidates,target,0,list);
            return res;
        }

        private void find(int[] candidates, int target , int curIndex,LinkedList<Integer> list) {
            if (target<0)return;
            else if (target == 0) res.add(new ArrayList<>(list));
            else
                for (int i = curIndex; i < candidates.length; i++) {
                    if(i > curIndex && candidates[i] == candidates[i-1]) continue;
                    list.push(candidates[i]);
                    find(candidates,target-candidates[i],i+1,list);
                    list.pop();
                }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = new Solution().combinationSum(arr, 8);
        System.out.println(lists);
    }

}
