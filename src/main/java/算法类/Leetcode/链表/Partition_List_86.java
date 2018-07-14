package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给出一个链表以及一个数x，将链表重新整理
 * 使得小于x的元素在前，大于等于x的元素在后
 * 143252  3
 * 122435
 */
public class Partition_List_86 {

    private static ListNode partitionList(ListNode head,int target) {
        if (head == null || head.next == null) return null;
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftCur = null;
        ListNode rightCur = null;
        ListNode cur = head;

        while (cur!=null){
            if (cur.val<target){
                if (leftHead == null) {
                    leftHead = cur;
                    leftCur = leftHead;
                }
                else {
                    leftCur.next = cur;
                    leftCur = leftCur.next;
                }
            }else {
                if (rightHead == null) {
                    rightHead = cur;
                    rightCur = rightHead;
                }
                else {
                    rightCur.next = cur;
                    rightCur = rightCur.next;
                }
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
        System.out.println(partitionList(head,4));
    }

}
