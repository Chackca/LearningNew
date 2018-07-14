package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给出一个链表，将链表重新整理
 * 使得所有索引为奇数的节点排在索引为偶数的节点前面
 * 索引从1开始计算
 */
public class Odd_Even_Linked_List_328 {

    private static ListNode oddEvenLinkedList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftCur = null;
        ListNode rightCur = null;
        ListNode cur = head;
        boolean isOdd = true;

        while (cur!=null){
            if (isOdd){
                if (leftHead == null) {
                    leftHead = cur;
                    leftCur = leftHead;
                }
                else {
                    leftCur.next = cur;
                    leftCur = leftCur.next;
                }
                isOdd = !isOdd;
            }else {
                if (rightHead == null) {
                    rightHead = cur;
                    rightCur = rightHead;
                }
                else {
                    rightCur.next = cur;
                    rightCur = rightCur.next;
                }
                isOdd = !isOdd;
            }
            if (cur.next!=null)
                cur = cur.next;
            else break;
        }
        if (rightCur.next!=null) rightCur.next=null;
        leftCur.next = rightHead;
        return leftHead;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,8,2,3,4,5,-1,-2,0,9};
        ListNode head = ListNode.createListNode(arr);
        System.out.println(oddEvenLinkedList(head));
    }

}
