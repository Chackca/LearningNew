package 算法类.剑指offer;

public class 题26树的子结构 {
	
	public static boolean hasSubtree(TreeNode<Integer> root1,TreeNode<Integer> root2) {
		boolean result = false;
		if(root1!=null && root2!=null){
			if (root1.val.equals(root2.val)) {
				result = DoesTree1HaveTree2(root1,root2);
			}
			if(!result){
				result = hasSubtree(root1.left,root2);
			}
			if(!result){
				result = hasSubtree(root1.right,root2);
			}
		}
		return result;
	}
	
	
	
	
	private static boolean DoesTree1HaveTree2(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if(root2==null){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(!root1.val.equals(root2.val)){
			return false;
		}
		return DoesTree1HaveTree2(root1.left, root2.left) &&
				DoesTree1HaveTree2(root1.right, root2.right);
	}




	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(7);
        root1.left.left = new TreeNode<>(9);
        root1.left.right = new TreeNode<>(2);
        root1.left.right.left = new TreeNode<>(4);
        root1.left.right.right = new TreeNode<>(7);
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(9);
        root2.right = new TreeNode<>(2);
        TreeNode<Integer> root3 = new TreeNode<>(2);
        root3.left = new TreeNode<>(4);
        root3.right = new TreeNode<>(3);
        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(root1,root3));
	}
}
