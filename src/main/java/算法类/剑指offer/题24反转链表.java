package 算法类.剑指offer;
/*
 * 理解有限
 */
public class 题24反转链表 {

	//采用迭代的做法
	public static ListNode<Integer> reverseList(ListNode<Integer> head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;

		//若输入为空或者为一个节点的链表
		/*if(head==null || head.next==null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        while(true){//pre-->cur-->post
        	cur.next = pre;	//当前节点的下一个节点为原本的上一个节点（当前节点不变）pre<--cur---post
        	pre = cur;		//将当前节点保存为下一个节点（当前节点不变）
        	cur = post;		//将当前节点设置为下一个节点（当前节点变化），此时下一个节点的状态未知
        	if (post!=null) {//判断下一个节点的状态
        		post=post.next;
			}else{
				return pre;
			}
        }*/
	}


	//采用递归的做法
	public static ListNode<Integer> reverseList2(ListNode<Integer> head) {
		// size == 0 or size == 1
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> newHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next=new ListNode<Integer>(2);
		head.next.next=new ListNode<Integer>(3);
		head.next.next.next=new ListNode<Integer>(4);
		head.next.next.next.next=new ListNode<Integer>(5);
		System.out.println(head);
		System.out.println(reverseList2(head));
		
		
		ListNode<Integer> head2 = new ListNode<Integer>(1);
		head2.next=new ListNode<Integer>(2);
		System.out.println(head2);
		System.out.println(reverseList2(head2));
	}
}
