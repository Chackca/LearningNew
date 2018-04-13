package 算法类.剑指offer;

public class 题552平衡二叉树 {
	
	/*
	 * 采用递归的方法，效率不高，节点会被重复计算
	 */
	private static boolean isBalanced(TreeNode<Integer> root) {
		if (root==null) {
			return true;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		if(left-right>1 ||left-right<-1){
			return false;
		}
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	/*
	 * 采用后序遍历的方法，每个节点只算一次
	 */
	//用后序遍历，并记录每个节点的深度，从而可以通过一次遍历完成整棵树的判断
    public static boolean isBalanced2(TreeNode<Integer> node){
        if(node==null)
            return true;
        int depth[] = new int[1];
        return isBalanced2Core(node,depth);
    }

	private static boolean isBalanced2Core(TreeNode<Integer> root, int[] depth) {
		if (root==null) {
			return true;
		}
        int left[] = new int[1];
        int right[] = new int[1];
 
		if (isBalanced2Core(root.left,left)&&isBalanced2Core(root.right,right)) {
			if ((left[0]- right[0]<=1)||(left[0]- right[0]>=-1)) {
				depth[0] = 1+ ((left[0]>right[0])?left[0]:right[0]) ;
				return true;
			}
		}

		return false;
	}
	
	
	public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root));
    }
	
	public static int treeDepth(TreeNode<Integer> root) {
		if (root==null) {
			return 0;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		return left>right?left+1:right+1;
	}

}
