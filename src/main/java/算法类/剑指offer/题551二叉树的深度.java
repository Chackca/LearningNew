package 算法类.剑指offer;

/*
 * 	面试题55：二叉树的深度
	
	题目要求：
	求二叉树的深度。仅仅包含一个根节点的二叉树深度为1。
	
	解题思路：
	二叉树root的深度比其子树root.left与root.right的深度的最大值大1。因此可以通过上述结论递归求解。
	如果不使用递归，可以通过层序遍历（广度优先遍历）解决。

 */
public class 题551二叉树的深度 {
	
	//题目一：二叉树的深度
	public static int treeDepth(TreeNode<Integer> root) {
		if (root==null) 
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return left>right?left+1:right+1;
	}

	
	
	
	
	public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(treeDepth(root));
    }

	
}
