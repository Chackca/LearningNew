package 算法类.Leetcode.链表;

/***
     Given a singly linked list L: L 0→L 1→…→L n-1→L n,
     reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
     You must do this in-place without altering the nodes' values.
     For example,
     Given{1,2,3,4}, reorder it to{1,4,2,3}.

    思路：快慢指针找到中间节点，将后面的链表反转（前插法），合并链表
 */
public class reorder_list {
   //Definition for singly-linked list.
   private static class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    public static class Solution {
        public static void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode fast = head;
            ListNode slow = head;
            //当快指针不是最后的节点或不是倒数第一个节点时
            while (fast.next !=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //以上循环结束后，slow即指向中间节点
            //反转slow.next开始的链表
            ListNode start = slow.next;
            slow.next = null;
            ListNode newhead = reverseLinkedList(start);

            merge(head,newhead);
            //System.out.println();
        }

        private static void merge(ListNode head, ListNode newhead) {
            while (head.next!=null && newhead.next!=null){
                ListNode headNext = head.next;
                ListNode newheadNext = newhead.next;
                head.next = newhead;
                newhead.next = headNext;
                head = headNext;
                newhead = newheadNext;
            }
            //用于处理总节点数为奇数个的情况
            if (head.next!=null && newhead.next==null){
                newhead.next = head.next;
                head.next = newhead;
            }//用于处理总节点数为偶数个的情况
            else if (head.next==null && newhead.next==null){
                head.next = newhead;
            }
        }

        //参数：头结点
        //返回值，反转后的头结点，原头结点指向了null
        private static ListNode reverseLinkedList(ListNode start) {
            if (start == null || start.next == null) return start;
            ListNode newhead = reverseLinkedList(start.next);
            start.next.next = start;
            start.next = null;
            return newhead;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        //head.next.next.next.next=new ListNode(5);
        Solution.reorderList(head);
        System.out.println();  //最后会变成1423

    }



}
