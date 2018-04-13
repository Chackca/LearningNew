package 算法类.程序员代码面试指南.chapter_1_stackandqueue;

import java.util.HashMap;
import java.util.Stack;

public class Problem_08_MaxTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int value) {
			this.value = value;
		}
	}

	public static Node getMaxTree(int[] arr) {
		Node[] nArr = new Node[arr.length];
		//将数组中的每个值都封装为Node节点，并添加到nArr数组中
		for (int i = 0; i != arr.length; i++) {
			nArr[i] = new Node(arr[i]);
		}
		//临时用的stack
		Stack<Node> stack = new Stack<Node>();
		//存储key=node左边第一个最大的值（node节点）
		HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
        //存储key=node右边第一个最大的值（node节点）
		HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
		//给lBigMap赋值，从左到右
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			//若栈不为空&&栈顶元素<当前值
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
			    //将栈顶元素弹出并设置其向左第一个大于它的元素为下一个栈顶元素
				popStackSetMap(stack, lBigMap);
			}
			stack.push(curNode);
		}
		//上面程序执行完了，栈不为空，则将当前数据存储到map中
		while (!stack.isEmpty()) {
			popStackSetMap(stack, lBigMap);
		}
        //给rBigMap赋值，从右到左
		for (int i = nArr.length - 1; i != -1; i--) {
			Node curNode = nArr[i];
			while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
				popStackSetMap(stack, rBigMap);
			}
			stack.push(curNode);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
		Node head = null;
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			//若当前节点的左边与右边都没有比他大的值，那么它肯定为树的根节点
			if (left == null && right == null) {
				head = curNode;
			} else if (left == null) {//若左边没有比当前节点大的值，而右边有
                //随机存储，从左到右，若左边已有孩子，则存到到右边
				if (right.left == null) {
					right.left = curNode;
				} else {
					right.right = curNode;
				}
			} else if (right == null) {//若右边没有比当前节点大的值，而左边有
                //随机存储，从左到右，若左边已有孩子，则存到到右边
				if (left.left == null) {
					left.left = curNode;
				} else {
					left.right = curNode;
				}
			} else {//取左右两边比较小的值作为它的父节点
				Node parent = left.value < right.value ? left : right;
				//随机存储，从左到右，若左边已有孩子，则存到到右边
				if (parent.left == null) {
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		return head;
	}

	public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
	    //由于将要压入的值大于当前栈顶元素
		Node popNode = stack.pop();
		if (stack.isEmpty()) {
			map.put(popNode, null);
		} else {
		    //设置当前node的向左/右的第一个大于它的值为栈顶元素
			map.put(popNode, stack.peek());
		}
	}

	public static void printPreOrder(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		printPreOrder(head.left);
		printPreOrder(head.right);
	}

	public static void printInOrder(Node head) {
		if (head == null) {
			return;
		}
		printPreOrder(head.left);
		System.out.print(head.value + " ");
		printPreOrder(head.right);
	}

	public static void main(String[] args) {
		int[] uniqueArr = { 3, 4, 5, 1, 2 };
		Node head = getMaxTree(uniqueArr);
		printPreOrder(head);
		System.out.println();
		printInOrder(head);

	}

}
