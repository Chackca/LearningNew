package 算法类.剑指offer;

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
		ListNode<Integer> head = new ListNode<>(1);	
		head.next=new ListNode<Integer>(2);
		head.next.next=new ListNode<Integer>(3);
		head.next.next.next=new ListNode<Integer>(4);
		head.next.next.next.next=new ListNode<Integer>(5);

		System.out.println(FindKthToTail(head,4).val);
	}
}
