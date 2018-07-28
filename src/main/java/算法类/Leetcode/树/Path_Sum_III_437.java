package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

import java.util.*;

/**
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
        /  \
      5   -3
    / \    \
   3   2   11
 / \   \
3  -2   1

     Return 3. The paths that sum to 8 are:

     1.  5 -> 3
     2.  5 -> 2 -> 1
     3. -3 -> 11
 */
public class Path_Sum_III_437 {

    private static int pathSum(TreeNode<Integer> root, int target) {
        if(root == null)
            return 0;
        int res = findPath(root,target);
        res += findPath(root.left,target);
        res += findPath(root.right,target);
        return res;
    }

    private static int findPath(TreeNode<Integer> root, int target) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.val == target)
            res++;
        res += findPath(root.left,target-root.val);
        res += findPath(root.right,target-root.val);
        return res;
    }

        public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        /*TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        System.out.println(pathSum(root,10));*/

        TreeNode<Integer> root = new TreeNode<Integer>(5);
        root.left = new TreeNode<Integer>(4);
        root.right = new TreeNode<Integer>(8);
        root.left.left = new TreeNode<Integer>(11);
        root.left.left.left = new TreeNode<Integer>(7);
        root.left.left.right = new TreeNode<Integer>(2);
        root.right.left = new TreeNode<Integer>(13);
        root.right.right = new TreeNode<Integer>(4);
        root.right.right.left = new TreeNode<Integer>(5);
        root.right.right.right = new TreeNode<Integer>(1);
        System.out.println(pathSum(root,22));
    }
}
