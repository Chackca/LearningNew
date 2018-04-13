package 算法类.剑指offer;

public class 未完成题36二叉搜索树与双向链表 {
	
	
	private static TreeNode<Integer> convert(TreeNode<Integer> root) {
		
		return null;
	}
	
	
	public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);
        TreeNode<Integer> result = convert(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        //System.out.println(result.leftToRight());

    }

	
}
