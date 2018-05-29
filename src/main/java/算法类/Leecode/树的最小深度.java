package 算法类.Leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 给定一个二叉树，找到它的最小深度。最小深度是沿着从根节点到最近的叶节点的最短路径的节点数。
 */
public class 树的最小深度 {

     //Definition for binary tree
     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public class Solution {
        public int run(TreeNode root) {
            if(root == null)
                return 0;
            if(root.left == null && root.right == null)
                return 1;

            int depth = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int len = queue.size();
                depth++;
                for(int i = 0; i < len; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left == null && cur.right == null)
                        return depth;
                    if(cur.left != null)
                        queue.offer(cur.left);
                    if(cur.right != null)
                        queue.offer(cur.right);
                }
            }
            return 0;
        }
    }




    public class Solution2 {
        public int run(TreeNode root) {
            if (root == null)
                return 0;
            int left = run(root.left);
            int right = run(root.right);
            if (left==0||right==0){
                return left+right+1;
            }
            return 1+Math.min(left,right);
        }
    }


}
