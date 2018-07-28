package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 反转一颗二叉树（镜像）
 */
public class Invert_Binary_Tree_226 {

    private static TreeNode invertBinaryTree(TreeNode<Integer> root) {
        if (root==null){
            return root;
        }
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        swap(root,root.left,root.right);
        return root;
    }

    private static void swap(TreeNode<Integer> root,TreeNode<Integer> left, TreeNode<Integer> right) {
        root.left = right;
        root.right =left;
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
        System.out.println(invertBinaryTree(root));
    }

}
