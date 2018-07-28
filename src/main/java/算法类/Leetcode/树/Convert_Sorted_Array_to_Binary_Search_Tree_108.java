package 算法类.Leetcode.树;


import 算法类.domain.TreeNode;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return insertNode(nums, 0, nums.length - 1);
    }
    public TreeNode insertNode(int[] nums, int lo, int hi) {
        if(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            TreeNode root  = new TreeNode(nums[mid]);
            root.left = insertNode(nums, lo, mid - 1);
            root.right = insertNode(nums, mid + 1, hi);
            return root;
        }
        return null;
    }
}
