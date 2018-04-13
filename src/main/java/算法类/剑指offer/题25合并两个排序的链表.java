package 算法类.剑指offer;

public class 题25合并两个排序的链表 {
	
	private static ListNode<Integer> Merger(ListNode<Integer> head1, ListNode<Integer> head2) {
		
		if (head1==null && head2==null) {
			return null;
		}else if(head1==null){
			return head2;
		}else if(head2==null){
			return head1;
		}
		ListNode<Integer> mergeListNode = null;
		
		if(head1.val < head2.val){
			mergeListNode = head1;
			mergeListNode.next = Merger(head1.next,head2);
		}else{
			mergeListNode = head2;
			mergeListNode.next = Merger(head1,head2.next);
		}
		
		
		return mergeListNode;
	}
	
	
	
	public static void main(String[] args) {
		ListNode<Integer> head1 = new ListNode<Integer>(-1);
		head1.next=new ListNode<Integer>(1);
		head1.next.next=new ListNode<Integer>(3);
		head1.next.next.next=new ListNode<Integer>(5);
		head1.next.next.next.next=new ListNode<Integer>(7);
		
		ListNode<Integer> head2 = new ListNode<Integer>(0);
		head2.next=new ListNode<Integer>(2);
		head2.next.next=new ListNode<Integer>(4);
		head2.next.next.next=new ListNode<Integer>(6);
		head2.next.next.next.next=new ListNode<Integer>(8);
		head2.next.next.next.next.next=new ListNode<Integer>(9);
		head2.next.next.next.next.next.next=new ListNode<Integer>(10);
		
		ListNode<Integer> node = Merger2(head1,head2);
		System.out.println(node);

	}
	
	/*
	 * 采用二路归并排序做法，非递归
	 */
	public static ListNode<Integer> Merger2(ListNode<Integer> head1, ListNode<Integer> head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
       ListNode<Integer> index1 = head1;
       ListNode<Integer> index2 = head2;
       ListNode<Integer> index = null;
       if(index1.val<index2.val) {
           index = index1;
           index1 = index1.next;
       }
       else {
           index = index2;
           index2 = index2.next;
       }
       while(index1!=null && index2!=null){
           if(index1.val<index2.val) {
               index.next = index1;
               index = index.next;
               index1 = index1.next;
           }
           else {
               index.next = index2;
               index = index.next;
               index2 = index2.next;
           }
       }
       if(index1!=null)
           index.next = index1;
       else
           index.next = index2;
       return head1.val<head2.val?head1:head2;
    }
}
