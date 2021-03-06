package 算法类.剑指offer;

/**
 * 题目要求：
 * 假设一个链表中包含环，请找出入口节点。若没有环则返回null。
 * 分析：
 * 1.	确定一个链表中包含环：用一快一慢指针，若快指针追上慢指针，则有环
 * 2.	确定环中节点数目k：在快指针追上慢指针的位置，让慢指针继续走，
 * 			记录慢指针走回此处所走过的节点数即为环中节点数k
 * 3.	找到环的入口节点：两个指针定位在链头，一个指针先走k步，
 * 			然后两指针同步走，若先走的指针碰到慢走的指针，那么那个位置就是环的入口
 */
public class 题23链表中环的入口节点 {

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next==null) return null;
		//1、一块一慢指针，两个指针相遇证明有环，记录当前点node
		ListNode slow = head;
		ListNode fast = head;
		ListNode meetNode = null;
		while (fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast){
				meetNode = slow;
				break;
			}
		}
		//若出现了等于null，则表示链表无环
		if (fast.next==null||fast.next.next==null) return null;

		slow = head;
		fast = meetNode;

		while (slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}


	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next=new ListNode<Integer>(2);
		head.next.next=new ListNode<Integer>(3);//
		head.next.next.next=new ListNode<Integer>(4);
		head.next.next.next.next=new ListNode<Integer>(5);
		head.next.next.next.next.next = head.next.next;

		ListNode<Integer> meetNode = detectCycle(head);

		System.out.println(meetNode.val);
	}




	/*
	 * 第一步，确定链表中包含环
	 * 用两个指针，一个一次走两步，一个一次走一步
	 * 若两个指针相遇，说明存在环，并返回相遇的节点
	 */
	/*public static ListNode<Integer> MeetingNode(ListNode<Integer> head){
		
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
	}*/
	
	/*
	 * 第二步，确认环中节点的数目
	 * 由相遇的节点出发，若再次走到此节点，则途中所走过的节点数即为环中的节点数
	 */
	/*public static int NodeNumberInCircle(ListNode<Integer> meetNode) {
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
	}*/
	
	
	
	
	/*
	 * 第三步，找到环的入口节点
	 * 定义两个指针，一个指针先走到相遇的节点，另一个
	 */
	/*public static ListNode<Integer> FindCircleInNode(ListNode<Integer> head ,int count) {
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
	}*/
	

}
