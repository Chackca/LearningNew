package 算法类.剑指offer;

public class 题27二叉树的镜像 {
	
	public static void mirrorRecursively(TreeNode<Integer> root) {
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			return;
		}
		//执行交换左右子树
		TreeNode<Integer> tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		if(root.left!=null){
			mirrorRecursively(root.left);
		}if(root.right!=null){
			mirrorRecursively(root.right);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(11);
        System.out.println(root);
        mirrorRecursively(root);
        System.out.println(root);
	}
}
