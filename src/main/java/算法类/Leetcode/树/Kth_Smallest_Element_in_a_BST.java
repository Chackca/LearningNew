package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分搜索树上寻找第k小的元素
 */
public class Kth_Smallest_Element_in_a_BST {
    private class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> result = new ArrayList<>();
            helper(root, k, result);
            return result.get(k-1);
        }
        private void helper(TreeNode<Integer> root, int k, List<Integer> result) {
            if(root != null && result.size()<k){
                helper(root.left, k, result);
                if(result.size()<k){
                    result.add(root.val);
                    helper(root.right, k, result);
                }
            }
        }
    }
}
