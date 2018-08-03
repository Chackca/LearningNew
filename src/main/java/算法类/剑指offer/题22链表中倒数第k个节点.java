package 算法类.剑指offer;

/**
 * 题目要求：
 * 求链表中倒数第k个节点。链表的尾节点定义为倒数第1个节点。
 * 分析：定义两个指针，让第一个指针从头先走k步，
 * 第二个指针指向链表头，然后两个指针同时向后走，
 * 若第二个指针走到队尾，那么第一个指针所指的就是倒数第k个节点
 */
public class 题22链表中倒数第k个节点 {
	
	public static ListNode<Integer> FindKthToTail(ListNode<Integer> head,int k) {
		if(head==null||k<=0)
			return null;
		
		ListNode<Integer> slow=head,fast=head;
		
		for(int i=1;i<k;i++){
			if(fast.next!=null){
				fast = fast.next;
			}else{
				return null;
			}
		}
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;	
	}
	
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode(1);
		head.next=new ListNode<Integer>(2);
		head.next.next=new ListNode<Integer>(3);
		head.next.next.next=new ListNode<Integer>(4);
		head.next.next.next.next=new ListNode<Integer>(5);

		System.out.println(FindKthToTail(head,4).val);
	}
}
