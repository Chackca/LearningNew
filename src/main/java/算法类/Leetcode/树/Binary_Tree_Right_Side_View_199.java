package 算法类.Leetcode.树;

import 算法类.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 想象你站在一颗二叉树的右侧，返回所有你能看见的节点
 * 即返回每一层最右边的节点
 */
public class Binary_Tree_Right_Side_View_199 {

    public static void solution(TreeNode node){
        if (node==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size-1; i++) {
                TreeNode cur = queue.poll();
                if (cur.left!=null)
                    queue.add(cur.left);
                if (cur.right!=null)
                    queue.add(cur.right);
            }
            TreeNode cur = queue.poll();
            if (cur.left!=null)
                queue.add(cur.left);
            if (cur.right!=null)
                queue.add(cur.right);
            System.out.println(cur.val);
        }

    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        //root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        //root.right.left = new TreeNode<Integer>(6);
        //root.right.right = new TreeNode<Integer>(7);
        solution(root);
    }

}
