package 算法类.剑指offer;
/*
 * 	面试题18：删除链表的节点
	
	题目要求：
	在o(1)时间内删除单链表的节点。
 */
public class 题181删除链表的节点 {
	
	/*
	 * 顺序查找，找到要删除节点的前一个结点的方法
	 */
	private static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> nodeToBeDelete) {
		if (head == null || nodeToBeDelete == null) {
			return null;
		}
		//要删除的节点是头结点
		if (head == nodeToBeDelete) {
			if (head.next!=null) {
				return head.next;
			}else return null;
		}
		ListNode<Integer> node = head;
		//要删除的节点不是头结点
		while (node.next!=null && node.next != nodeToBeDelete) {
			node = node.next;
		}
		if (node.next==nodeToBeDelete) {
			if (node.next.next!=null) {
				node.next = node.next.next;
				node.next.val = node.next.next.val;
			}else {
				//删除的节点是尾节点
				node.next=null;
			}
			return head;
		}
		
		return null;
	}
	
	/*
	 * 直接将下一个节点的值赋值到当前节点以覆盖实现删除当前节点的方法
	 */
	private static ListNode<Integer> deleteNode2(ListNode<Integer> head, ListNode<Integer> nodeToBeDelete) {
		if (head == null || nodeToBeDelete == null) {
			return null;
		}
		ListNode<Integer> node = head;
		//要删除的节点是头结点
		if (head == nodeToBeDelete) {
			if (head.next!=null) {
				return head.next;
			}else
				return null;
		}
		//要删除的节点是尾结点
		else if (nodeToBeDelete.next==null) {
			while (node.next!=null && node.next != nodeToBeDelete) {
				node = node.next;
			}
			node.next =null;
			return head;
		}
		//要删除的节点不是尾结点也不是头结点	
		else {
			//node = nodeToBeDelete;
			nodeToBeDelete = nodeToBeDelete.next;
			nodeToBeDelete.val =nodeToBeDelete.next.val;
			return head;
		}
		
	}
	public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode2(head,node3);
        System.out.println(head);
        head = deleteNode2(head,head);
        System.out.println(head);
    }

}
