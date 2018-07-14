package 算法类.Leetcode.链表;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 在 O（n log n）的时间内，使用恒定的空间复杂度来排序一个链表。
 */

import 算法类.domain.ListNode;

/**
 * 思路：使用归并排序  加  快慢指针的做法，每次找到链表的中间节点，再进行左边排序，右边排序
 * 找到中间节点用快慢指针的方法
 */
public class 使用归并排序来排序一个链表148 {


     //Definition for singly-linked list.
     /*private static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }*/



    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(8);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(3);
        ListNode res = sortList(node);
        System.out.println(res);
    }

    public static ListNode sortList(ListNode left) {
         if (left == null || left.next == null) return left;
         //找到中间节点
         ListNode mid = findMid(left);

         //分割成两个链表
        ListNode right = mid.next;
        mid.next = null;
        //左边与右边排序
        ListNode newLeft = sortList(left);
        ListNode newRight = sortList(right);
        //归并排序链表
        return sortMerge(newLeft,newRight);
    }

    //使用一快一慢指针找到中间节点
    private static ListNode findMid(ListNode head) {
        if (head == null)  return null;
        if (head.next== null)  return head;
        ListNode slow = head;
        ListNode fast = head;
        //快指针处于倒数第一、倒数第二的时候就不能继续走， 退出返回slow
        while (fast.next !=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //归并排序链表
    private static ListNode sortMerge(ListNode head1, ListNode head2) {
        ListNode left = head1;
        ListNode right = head2;

        if (left == null) return right;
        if (right == null) return left;

        ListNode result,newhead;
        if (left.val>right.val){
            newhead = result = right;
            right=right.next;
        }else {
            newhead = result = left;
            left=left.next;
        }

        while (left!=null&&right!=null){
            if (left.val>right.val){
                result.next = right;
                right=right.next;
            }else {
                result.next = left;
                left=left.next;
            }
            result = result.next;
        }

        if (left == null) result.next = right;
        if (right == null) result.next = left;

         return newhead;
    }

}

