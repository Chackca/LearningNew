package 算法类.Leetcode.递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Combinations_Sum_39 {

    private static List<List<Integer>> res = new ArrayList<>();
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null)
                return res;
            LinkedList<Integer> list = new LinkedList();
            find(candidates,target,0,list);
            return res;
        }

        private void find(int[] candidates, int target , int curIndex,LinkedList<Integer> list) {
            if (target<0)return;
            else if (target == 0) res.add(new ArrayList<>(list));
            else
                for (int i = curIndex; i < candidates.length; i++) {
                    list.push(candidates[i]);
                    find(candidates,target-candidates[i],i,list);
                    list.pop();
                }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        List<List<Integer>> lists = new Solution().combinationSum(arr, 7);
        System.out.println(lists);
    }

}
