package 算法类.剑指offer;

import java.util.Stack;

public class 题6从尾到头打印链表 {
	
	/*
	 * 用递归实现
	 */
	private static void printReversinglyRecursively(ListNode<Integer> head) {
		if (head == null) return;
		
		printReversinglyRecursively(head.next);
		System.out.print(head.val);
	}
	
	/*
	 * 用迭代实现，栈
	 */
	private static void printReversinglyIteratively(ListNode<Integer> head) {
		if (head == null) return;
		Stack<ListNode<Integer>> stack = new Stack();
		stack.push(head);
		while(head.next!=null){
			head = head.next;
			stack.push(head);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().val);
		}
		
	}
	
	
	public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        System.out.println("递归方法如下：");
        printReversinglyRecursively(head);
        System.out.println();
        System.out.println("迭代方法如下：");
        printReversinglyIteratively(head);
    }

	
}
