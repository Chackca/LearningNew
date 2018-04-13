package 算法类.剑指offer;

import java.util.ArrayList;

public class 题54二叉搜索树中的第k大节点 {
	
	
	private static Integer kthNode(TreeNode<Integer> root, int i) {
		if (root == null ||i<=0) {
			return null;
		}
		//用数组，需要考虑数组大小，占用空间且无法确认
		//用ArrayList可以随意开辟大小，适合
		ArrayList<Integer> list = new ArrayList<Integer>();
			
		midSearch(root,list);
		
		if (i<=list.size()) {
			return list.get(i-1);
		}
		
		return null;
		
	}
	
	private static void midSearch(TreeNode<Integer> root, ArrayList<Integer> list) {
		if (root!=null) {
			midSearch(root.left,list);
			list.add(root.val);
			midSearch(root.right,list);
		}
	}

	public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        
        System.out.println(kthNode(root,3));//4
        System.out.println(kthNode(root,6));//7
        System.out.println(kthNode(root,8));//null
    }

	
}