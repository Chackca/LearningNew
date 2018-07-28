package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 给定一棵完全二叉树，求完全二叉树的节点个数
 */
public class Count_Complete_TreeNode_222 {

    //没有利用完全二叉树的特性，会超时
    private static int countCompleteTreeNode(TreeNode<Integer> root) {
        if (root==null) return 0;
        // 二叉树的节点数 = 左子树的节点数 + 右子树的节点数 + 1
        if(root == null){
            return 0;
        }
        return countCompleteTreeNode(root.left) + countCompleteTreeNode(root.right) + 1;
    }


    /**
     * 利用完全二叉树的版本
     */
    public static int countCompleteTreeNode2(TreeNode<Integer> root){
        if (root==null)return 0;
        int leftDepth = getLeftDepth(root.left);
        int rightDepth = getRightDepth(root.right);
        if (leftDepth==rightDepth)
            return (1<<leftDepth)-1;
        else
            return countCompleteTreeNode2(root.left)+countCompleteTreeNode2(root.right)+1;
    }

    private static int getRightDepth(TreeNode<Integer> root) {
        if (root==null)
            return 0;
        int res = 1;
        while (root!=null){
            root = root.right;
            res++;
        }
        return res;
    }

    private static int getLeftDepth(TreeNode<Integer> root) {
        if (root==null)
            return 0;
        int res = 1;
        while (root!=null){
            root = root.left;
            res++;
        }
        return res;
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

        System.out.println(countCompleteTreeNode2(root));
    }


}
