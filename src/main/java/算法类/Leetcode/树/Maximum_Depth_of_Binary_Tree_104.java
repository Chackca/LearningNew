package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 求一颗二叉树的最高深度
 * 从根节点到叶子节点的最长路径
 */
public class Maximum_Depth_of_Binary_Tree_104 {

    private static int maxDepth(TreeNode<Integer> root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
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

        System.out.println(maxDepth(root));
    }

}

