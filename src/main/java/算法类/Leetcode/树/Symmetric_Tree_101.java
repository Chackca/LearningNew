package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 给出一棵二叉树，判断其是否是左右对称的
 */
public class Symmetric_Tree_101 {

    // Recursive
    // Revert one child tree and see if the two child trees of the root are identical
    private static boolean symmetricTree(TreeNode<Integer> root) {
        if (root==null) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        right = reverse(right);
        return isSame(left,right);
    }

    private static TreeNode reverse(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        reverse(left);
        reverse(right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static boolean isSame(TreeNode left, TreeNode right) {
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        if (left.val!=right.val)
            return false;
        return isSame(left.left,right.left)
                &&isSame(left.right,right.right);
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     2
        //       /  \   / \
        //      3    4 4   3
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.left.right = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(4);
        root.right.right = new TreeNode<Integer>(3);

        System.out.println(symmetricTree(root));
    }

}
