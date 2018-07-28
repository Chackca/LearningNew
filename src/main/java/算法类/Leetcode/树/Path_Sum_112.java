package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

/**
 * 给出一棵二叉树以及一个数字num，判断在这棵二叉树上是否存在
 * 一条从根到叶子的路径，其路径上的所有结点和为sum
 */
public class Path_Sum_112 {

    private static boolean pathSum(TreeNode<Integer> root,int target) {
        if (target<0 || root == null )
            return false;
        target = target-root.val;
        if (target == 0 && root.left==null && root.right==null)
            return true;
        return pathSum(root.left,target) ||
                pathSum(root.right,target);
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
        System.out.println(pathSum(root,10));
    }
}
