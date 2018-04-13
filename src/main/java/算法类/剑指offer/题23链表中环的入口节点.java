package 算法类.剑指offer;

public class 题23链表中环的入口节点 {
	
	/*
	 * 第一步，确定链表中包含环
	 * 用两个指针，一个一次走两步，一个一次走一步
	 * 若两个指针相遇，说明存在环，并返回相遇的节点
	 */
	public static ListNode<Integer> MeetingNode(ListNode<Integer> head){
		
		if(head==null)
			return null;
		ListNode<Integer> fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow = slow.next;
			if(fast==slow){
				return fast;
			}
		}
		System.out.println("该链表没有环，找不到两指针相遇的节点");
		return null;
	}
	
	/*
	 * 第二步，确认环中节点的数目
	 * 由相遇的节点出发，若再次走到此节点，则途中所走过的节点数即为环中的节点数
	 */
	public static int NodeNumberInCircle(ListNode<Integer> meetNode) {
		int count = 0;
		ListNode<Integer> node = meetNode;
		while(node != null && node.next !=null){
			node = node.next ;
			count++;
			if(node==meetNode){
				break;
			}
		}
		return count;
	}
	
	
	
	
	/*
	 * 第三步，找到环的入口节点
	 * 定义两个指针，一个指针先走到相遇的节点，另一个
	 */
	public static ListNode<Integer> FindCircleInNode(ListNode<Integer> head ,int count) {
		if(head == null){
			return null;
		}
		ListNode<Integer> fast=head,slow=head;
		for(int i =0 ; i<count; i++){
			fast=fast.next;
		}
		while(fast.next!=slow.next){
			fast=fast.next;
			slow=slow.next;
		}
		return fast;	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next=new ListNode<Integer>(2);
		head.next.next=new ListNode<Integer>(3);//
		head.next.next.next=new ListNode<Integer>(4);
		head.next.next.next.next=new ListNode<Integer>(5);
		head.next.next.next.next.next = head.next.next;
		
		
		ListNode<Integer> meetNode = null;
		ListNode<Integer> circleInNode = null;
		meetNode = MeetingNode(head);
		if(meetNode != null){
			int number = NodeNumberInCircle(meetNode);
			circleInNode = FindCircleInNode(head,number);
		}
		
		System.out.println(circleInNode);	
	}
}
