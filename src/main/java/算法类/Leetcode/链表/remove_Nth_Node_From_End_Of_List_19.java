package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给定一个链表，删除倒数第n个节点
    解法一：先遍历一遍计算链表长度，再遍历一遍删除倒数第n个节点
    解法二：只遍历一遍链表
 */
public class remove_Nth_Node_From_End_Of_List_19 {

    private static ListNode removeNthNodeFromEndOfList(ListNode head,int n) {
        if (head == null || n<0) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }

        while (fast !=null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode deleteNode = slow.next;
        slow.next = deleteNode.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        ListNode head = ListNode.createListNode(arr);
        System.out.println(removeNthNodeFromEndOfList(head,2));
    }

}
