package 算法类.剑指offer;

import java.util.ArrayList;

/**
 * 题目要求：
 * 找出二叉搜索树的第k大节点。例如，在下图的树里，第3大节点的值为4，输入该树的根节点，3，则输出4。
 *
 *         5
 *        / \
 *       3   7
 *     / \   /  \
 *    2  4  6  8
 * 解题思路：
 * 二叉搜索树的中序遍历是有序的。可以引入一个计数器，每访问一个节点，计数器+1，当计数器等于k时，被访问节点就是该二叉搜索树的第k大节点。
 */
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
        TreeNode<Integer> root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        
        System.out.println(kthNode(root,3));//4
        System.out.println(kthNode(root,6));//7
        System.out.println(kthNode(root,8));//null
    }

	
}