package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 判断一棵二叉树是否为平衡二叉树
 */
public class Balance_Binary_Tree_110 {

    //尝试判断左右子树的深度depth比较后返回布尔值
    private static boolean balanceBinaryTree(TreeNode<Integer> root) {
        if (root==null)return false;
        return (depth(root)!=-1);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        else return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     2
        //       /  \   / \
        //      3    4 4   3
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        //root.right = new TreeNode<Integer>(2);
        root.left.left = new TreeNode<Integer>(3);
        root.left.right = new TreeNode<Integer>(4);
        //root.right.left = new TreeNode<Integer>(4);
        //root.right.right = new TreeNode<Integer>(3);

        System.out.println(balanceBinaryTree(root));
    }


}
