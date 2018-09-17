package 算法类.Leetcode.递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列：经典的回溯递归算法：
 * 给定一个整形数组，其中的每一个元素都各不相等，返回这些元素所有排列的可能
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permutations {
    private class Solution {
        List<List<Integer>> res;
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<List<Integer>>();
            if(nums == null || nums.length == 0)
                return res;

            used = new boolean[nums.length];
            LinkedList<Integer> p = new LinkedList<Integer>();
            generatePermutation(nums, 0, p);
            return res;
        }
        private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){
            if(index == nums.length){
                res.add((LinkedList<Integer>)p.clone());
                return;
            }

            for(int i = 0 ; i < nums.length ; i ++)
                if(!used[i]){
                    used[i] = true;
                    p.addLast(nums[i]);
                    generatePermutation(nums, index + 1, p );
                    p.removeLast();
                    used[i] = false;
                }

            return;
        }

        private void printList(List<Integer> list){
            for(Integer e: list)
                System.out.print(e + " ");
            System.out.println();
        }

    }
}
