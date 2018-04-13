package 算法类.剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 题32从上到下打印二叉树 {
	
	private static void printTreeInLine(TreeNode<Integer> root) {
		if(root == null)
			return;
		//StringBuilder SB = new StringBuilder("[");
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);//将当前的树（根节点）放入队列第一位
		TreeNode<Integer> temp = null;		
		while(!queue.isEmpty()){
			for(int size=queue.size() ; size>0;size--){
				temp = queue.poll();
				System.out.print(temp.val);
				System.out.print("\t");
				if(temp.left!=null)
					queue.offer(temp.left);
				if(temp.right!=null)
					queue.offer(temp.right);	
			}
			System.out.println();
			//SB.append("/n");
		}
		//SB.append("]");
		//System.out.println(SB.toString());
	}
	
	
	private static void printTreeInQueue(TreeNode<Integer> root) {
		if(root == null)
			return;
		StringBuilder SB = new StringBuilder("[");
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);//将当前的树（根节点）放入队列第一位
		TreeNode<Integer> temp = null;		
		while(!queue.isEmpty()){
			temp = queue.poll();
			SB.append(temp.val);
			if(temp.left!=null)
				queue.offer(temp.left);
			if(temp.right!=null)
				queue.offer(temp.right);			
		}
		SB.append("]");
		System.out.println(SB.toString());
	}
	
	
	//按之字形打印
	/*
	 * 用两个栈
	 * 1栈当前打印的为奇数行，保存他们的左右子节点到第一个栈里
	 * 2栈当前打印的为偶数行，保存他们的右左子节点到第二个栈里
	 */
	private static void printTreeInZhi(TreeNode<Integer> root) {
		if(root == null)return;
		//用于保存  左右  子节点
		Stack<TreeNode<Integer>> stack1 = new Stack<>();
		//用户保存  右左  子节点
		Stack<TreeNode<Integer>> stack2 = new Stack<>();
		
		TreeNode<Integer> temp = null ;
		stack2.push(root);
		
		while(!stack1.isEmpty()||!stack2.isEmpty()){	
			while(!stack1.isEmpty()){
				temp = stack1.pop();
				System.out.print(temp.val);
				if(temp.right!=null)stack2.push(temp.right);
				if(temp.left!=null)stack2.push(temp.left);
			}
			while(!stack2.isEmpty()){
				temp = stack2.pop();
				System.out.print(temp.val);
				if(temp.left!=null)stack1.push(temp.left);
				if(temp.right!=null)stack1.push(temp.right);
			}
		}
	}
	
	
	

	public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        printTreeInQueue(root);//不分行从上到下打印二叉树
        System.out.println();
        printTreeInLine(root);//分行从上到下打印二叉树
        System.out.println();
        printTreeInZhi(root);//按照之字形打印二叉树
        System.out.println();
        //测试打印前序遍历SB.append(",");
        System.out.println(root.toFrontString());
        //测试打印中序遍历
        System.out.println(root.toMidString());
        //测试打印后序遍历
        System.out.println(root.toBackString());
    }

	
}
