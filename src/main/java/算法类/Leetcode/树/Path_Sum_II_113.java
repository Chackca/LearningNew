package 算法类.Leetcode.树;

import sun.reflect.generics.tree.Tree;
import 算法类.domain.TreeNode;

import java.util.*;

/**
 * 给出一棵二叉树以及一个数字num，f返回所有从根节点到
 * 叶子节点的路径，其值为sum
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 思路：采用DFS深度优先遍历，二叉树中序遍历，左中右，用栈存储值
 */
public class Path_Sum_II_113 {

    /**
     * leetcode最快的标准答案
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res=new LinkedList<>();
            if (root==null)
                return res;
            helper(res, new ArrayList<>(), sum, root);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> path, int sum, TreeNode<Integer> root) {
            if (root.left==null&&root.right==null) {
                if (sum==root.val) {
                    path.add(root.val);
                    res.add(new ArrayList<>(path));
                    path.remove(path.size()-1);
                }
                return;
            }

            path.add(root.val);
            if (root.left!=null)
                helper(res, path, sum-root.val, root.left);
            if (root.right!=null)
                helper(res, path, sum-root.val, root.right);
            path.remove(path.size()-1);
            return;
        }
    }


    private static class Common{
        TreeNode<Integer> node;
        boolean checkLeft = false;
        boolean checkRight = false;
        public Common(TreeNode node){
            this.node = node;
        }
        public void setCheckRight(){
            checkRight = true;
        }
        public void setCheckLeft(){
            checkLeft = true;
        }
    }

    private static List<List<Integer>> pathSum(TreeNode<Integer> root, int target) {
        List list = new ArrayList();
        if (root == null ) return list;
        Stack<Common> stack = new Stack();
        stack.push(new Common(root));
        List<List<Integer>> res = DFS(list,target,stack);
        return res;
    }

    private static List<List<Integer>> DFS(List list, int target, Stack<Common> stack) {
        if (stack.isEmpty())
            return list;
        TreeNode<Integer> node = stack.peek().node;
        ArrayList<Integer> innerList = new ArrayList();
        if (node.left==null && node.right==null) {
            int temp = target;
            Iterator<Common> iterator = stack.iterator();
            while (iterator.hasNext()){
                Common common = iterator.next();
                temp = temp-common.node.val;
                innerList.add(common.node.val);
            }
            if (temp == 0)
                list.add(innerList);

            stack.pop();
            return list;
        }
        //innerList.add(node.val);
        if ( !stack.peek().checkLeft && node.left !=null ) {
            stack.push(new Common(node.left));
            DFS(list, target, stack);
        }
        stack.peek().checkLeft = true;
        if ( !stack.peek().checkRight && node.right !=null ) {
            stack.push(new Common(node.right));
            DFS(list, target, stack);
        }
        stack.peek().checkRight = true;
        if (stack.peek().checkRight && stack.peek().checkLeft)
            stack.pop();
        return list;
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
