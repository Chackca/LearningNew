package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给出一个有序链表，删除其中所有重复元素
 * 如11233->123
 */
public class Remove_Duplicates_from_Sorted_List {

    private static ListNode removeDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode cur = head;
        ListNode next = null;
        while (cur.next!=null){
            next = cur.next;
            if (cur.val==next.val){
                while (next!=null && cur.val == next.val ){
                    next = next.next;
                }
                cur.next=next;
            }else {
                cur = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,3,4,5,5,5,5};
        ListNode head = ListNode.createListNode(arr);
        System.out.println(removeDuplicates(head));
    }



}
