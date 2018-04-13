package 算法类.剑指offer;

import java.util.Stack;

/*
 * 题目要求：
	输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
	从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

	解题思路：
	需要得到所有从根节点到叶节点的路径，判断和是否为给定值。自己写一个小的二叉树，
	通过模拟上述过程，发现获取所有路径的过程与前序遍历类似。
	因此，可以对给定二叉树进行前序遍历。当被访问节点时叶节点时，
	判断路径和是否为给定值。此外，为了记录路径上的节点，需要一个数组。

 */
public class 题34二叉树中和为某一值的路径 {
	
	
	private static void findPath(TreeNode<Integer> root, int exceptedSum) {
		if (root ==null) return ;
		if (root.left==null && root.right==null) {
			if (root.val == exceptedSum) {
				System.out.println(root.val);
				return ;
			}
		}
		int curentSum = 0;
		Stack<Integer> stack = new Stack<>();
		findPath(root,exceptedSum,curentSum,stack);
	}
	

	private static void findPath(TreeNode<Integer> root, int exceptedSum, int curentSum, Stack<Integer> stack) {
		stack.push(root.val);
		curentSum = curentSum+root.val;
		if (curentSum<=exceptedSum) {
			if (root.left!=null) 
				findPath(root.left,exceptedSum,curentSum,stack);
			if (root.right!=null) 
				findPath(root.right,exceptedSum,curentSum,stack);
			//如果是叶节点
			if (root.left==null&&root.right==null&&exceptedSum == curentSum) 
				System.out.println(stack.toString());
		}
		stack.pop();
	}



	public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        findPath(root,22);
        //findPath2(root,22);
    }

	
}
