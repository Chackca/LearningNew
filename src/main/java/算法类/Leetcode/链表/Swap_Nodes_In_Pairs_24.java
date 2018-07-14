package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给定一个链表，对于每两个相邻的节点，交换其位置
 */
public class Swap_Nodes_In_Pairs_24 {

    private static ListNode swapNodesInPairs(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next!=null && p.next.next!=null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        ListNode head = ListNode.createListNode(arr);
        System.out.println(swapNodesInPairs(head));
    }


}
