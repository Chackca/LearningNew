package 算法类.Leetcode.树;

import java.util.ArrayList;
import java.util.Stack;

/**
 Given a binary tree, return the postorder traversal of its nodes' values.
 给定一个二叉树，返回其节点值的postorder遍历。
 For example:
 Given binary tree{1,#,2,3},
 1
  \
   2
  /
 3

 return[3,2,1].
 Note: Recursive solution is trivial, could you do it iteratively?
 //注意：递归解决方案是微不足道的，您可以迭代地完成吗？
 */
public class 输出树的后序遍历 {

    //Definition for binary tree
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static class Solution {
        public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        TreeNode p = root, r = null;        //P记录当前节点，r用来记录上一次访问的节点
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(p != null || !s.isEmpty()) {
            if(p != null) {     //左孩子一直入栈，直到左孩子为空
                s.push(p);
                p = p.left;
            } else { //到了这一步表示p为空了
                p = s.peek(); //取出前面的节点
                p = p.right;  //将当前节点转换为前面节点的右节点
                if(p != null && p != r) {   //如果栈顶元素的右孩子不为空，且未被访问过
                    s.push(p);              //则右孩子进栈，然后重复左孩子一直进栈直到为空的过程
                    p = p.left;
                } else {     //如果右节点也为空
                    r = s.pop();
                    list.add(r.val);
                    p = null;
                }
            }
        }
        return list;
    }
        
        
        //自己写的，该方法会导致遍历完树变成空的
        public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
            if (root == null) return new ArrayList<>();
            ArrayList<Integer> list= new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode head = stack.peek();
                if (head.right!=null)
                    stack.push(head.right);
                if (head.left!=null)
                    stack.push(head.left);
                if (head.left == null && head.right == null){
                    head = stack.pop();
                    list.add(head.val);
                }
                head.left = head.right = null;
            }
            return list;
        }


        public static void main(String[] args) {
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(12);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(7);
            System.out.println(Solution.postorderTraversal(root));
        }
    }
}


