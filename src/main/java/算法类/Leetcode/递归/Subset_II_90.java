package 算法类.Leetcode.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Subset_II_90 {
    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        System.out.println(subsets(arr));
    }

}
