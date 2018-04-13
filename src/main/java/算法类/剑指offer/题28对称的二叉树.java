package 算法类.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class 题28对称的二叉树 {
    //递归实现
    public static boolean isSymmetrical(TreeNode<Integer> root){
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        return isSymmetrical(root.left,root.right);
    }
    public static boolean isSymmetrical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(!root1.val.equals(root2.val))
            return false;
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }
    
    
    
    //迭代实现
    //查看前序遍历（根左右）和对称前序遍历（根右左）是否一样
    public static boolean isSymmetrical2(TreeNode<Integer> root){
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;

        Queue<TreeNode<Integer>> queueLeft = new LinkedList<>();
        Queue<TreeNode<Integer>> queueRight = new LinkedList<>();
        queueLeft.offer(root.left);
        queueRight.offer(root.right);
        TreeNode<Integer> tempLeft,tempRight;
        while(!queueLeft.isEmpty()|| !queueRight.isEmpty()){
            tempLeft = queueLeft.poll();
            tempRight = queueRight.poll();
            if(tempLeft.val.equals(tempRight.val)){
                if(tempLeft.left!=null)
                    queueLeft.offer(tempLeft.left);
                if(tempLeft.right!=null)
                    queueLeft.offer(tempLeft.right);
                if(tempRight.right!=null)
                    queueRight.offer(tempRight.right);
                if(tempRight.left!=null)
                    queueRight.offer(tempRight.left);
            }
            else
                return false;
        }
        if(queueLeft.isEmpty() && queueRight.isEmpty())
            return true;
        else
            return false;
    }

	
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(6);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(7);
        root.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root));
        System.out.println(isSymmetrical2(root));
	}
}
