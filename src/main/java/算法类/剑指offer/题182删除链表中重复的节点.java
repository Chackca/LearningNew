package 算法类.剑指offer;

/*
 * 题目要求：在一个排序链表中，删除重复的节点。比如[1,2,2,3,3,3],删除之后为[1];

	解题思路：
	由于是已经排序好的链表，需要确定重复区域的长度，
	删除后还需要将被删去的前与后连接，所以需要三个节点pre,cur,post，cur-post为重复区域，
	删除后将pre与post.next连接即可。
	此外，要注意被删结点区域处在链表头部的情况，因为需要修改head。

 */
public class 题182删除链表中重复的节点 {
	
	private static ListNode<Integer> deleteDuplication(ListNode<Integer> head) {
		if (head == null) return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        boolean needDelete ;
        while (post!=null){
            needDelete = false;
            //如果下一个节点的值与当前节点一样
            if (cur.val.equals(post.val)){
                needDelete = true;
                while (post.next!=null && post.next.val == cur.val){
                    post = post.next;
                }
            }else {//说明当前遍历中没有重复
                pre = cur ;
                cur = post;
                post = post.next;
            }
            if (needDelete && post.next !=null ){ //当前有重复并且重复没有到达链表最后
                if(cur == head){
                    head = post.next;
                }
                cur = post.next;
                pre = null;
                post = post.next.next;
                cur.next = post;
            }else if (needDelete){ //否则说明pre的后面都是重复的同一个数了
                if (pre == null){
                    return null;
                }
                pre.next = null;
                post = post.next;
            }
        }

		return head;
	}
	
	
	
	public static void main(String[] args){
        /*ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);*/
        
        
        ListNode<Integer> head2 = new ListNode<>(1);
        head2.next= new ListNode<>(1);
        head2.next.next = new ListNode<>(2);
        head2.next.next.next = new ListNode<>(3);
        head2.next.next.next.next = new ListNode<>(4);
        head2.next.next.next.next.next = new ListNode<>(1);
        System.out.println(head2);
        head2 = deleteDuplication(head2);
        System.out.println(head2);
    }
	
	
	public static ListNode<Integer> deleteDuplication2(ListNode<Integer> head){
        if(head==null||head.next==null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        boolean needDelete = false;
        while (post!=null){
            if(cur.val.equals(post.val)){
                needDelete = true;
                post=post.next;
            }
            else if(needDelete && !cur.val.equals(post.val)){
                if(pre==null)
                    head = post;
                else
                    pre.next=post;
                cur = post;
                post = post.next;
                needDelete = false;
            }
            else{
                pre = cur;
                cur = post;
                post = post.next;
            }
        }
        if(needDelete && pre!=null)
            pre.next = null;
        else if(needDelete && pre==null)
            head = null;
        return head;
    }

}
