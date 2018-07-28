package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 求出一棵二叉树所有左叶子节点的和，注意是叶子节点
 */
public class Sum_Of_Left_Leaves_404 {
    private static int sumOfLeftLeaves(TreeNode<Integer> root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}
