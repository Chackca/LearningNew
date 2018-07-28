package 算法类.Leetcode.树;
/**
 * 给定一棵二分搜索树和两个节点，寻找他们的最低公共祖先
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 */
public class Lowest_Common_Ancestor_Of_A_BinarySearchTree_235 {

     private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    private class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null ) return null;
            if (p.val<root.val&&q.val<root.val)
                return lowestCommonAncestor(root.left,p,q);
            if (p.val>root.val&&q.val>root.val)
                return lowestCommonAncestor(root.right,p,q);

            return root;
        }
    }
}
