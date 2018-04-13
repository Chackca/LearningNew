package 算法类.剑指offer;

public class 题52两个链表的第一个公共节点 {
	
	private static ListNode<Integer> findFirstCommonNode2(ListNode<Integer> head1, ListNode<Integer> head2) {
		//验证输入合法性
		if(head1 == null||head2==null){
			return null;
		}if (head1==head2) {
			return head1;
		}
		int length1=1,length2=1,distance=0;
		//创建一个用于记录两个指针位置的索引
		ListNode<Integer> index1=head1;
		ListNode<Integer> index2=head2;

		int whichIsShort = 1;
		//得到两个链表的长度
		while (head1.next!=null) {head1=head1.next;length1++;}
		while (head2.next!=null) {head2=head2.next;length2++;}

		//获取他们的长度差distance
		if (length1>length2) {
			//1大于2，1要先走distance步
			distance=length1-length2;
			whichIsShort = 2;
			//让1链表先走distance步
			for (;distance!=0;distance--) {
				index1=index1.next;
			}
		}else if (length1<length2) {
			//2大于1,2要先走distance步
			distance=length2-length1;
			whichIsShort = 1;
			//让2链表先走distance步
			for (;distance!=0;distance--) {
				index2=index2.next;
			}
		}
		int end ;
		if (whichIsShort==1) {
			end=length1;
		}else {
			end=length2;
		}
		//同时遍历两个链表
		for (int i = 0; i < end; i++) {
			if (index1==index2) {
				return index1;
			}else {
				index1=index1.next;
				index2=index2.next;
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args){
        // 1->2->3->6->7
        //    4->5↗
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        
        
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        
        ListNode<Integer> commonNode3 = findFirstCommonNode2(node1,node4);
        System.out.println(commonNode3.val);
    }

	
}
