package 算法类.Leetcode.树;

import java.util.ArrayList;
import java.util.Stack;

public class 输出树的前序遍历 {

    /*
    Given a binary tree, return the preorder traversal of its nodes' values.
    For example:
    Given binary tree{1,#,2,3},
            1
             \
              2
             /
            3

            return[1,2,3].
        Note: Recursive solution is trivial, could you do it iteratively?
        //注意：递归解决方案是微不足道的，您可以迭代地完成吗？
    */

    //Definition for binary tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Solution {
        public static ArrayList<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            ArrayList<Integer> list = new ArrayList();

            while (!stack.empty()){
                TreeNode head = stack.pop();
                //stack.pop();
                list.add(head.val);
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(Solution.preorderTraversal(root));
    }
}
