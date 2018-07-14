package 算法类.Leetcode.链表;

/**
 *  Given a linked list, determine if it has a cycle in it.
     Follow up:
    Can you solve it without using extra space?

     给定一个链表，确定它是否有一个循环。
     跟进:
     你能在不使用额外空间的情况下解决吗？
 */

public class 查看链表是否有环 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public static boolean hasCycle(ListNode head) {
            if (head == null || head.next==null) return false;
            //1、一块一慢指针，两个指针相遇证明有环，记录当前点node
            ListNode slow = head;
            ListNode fast = head;
            ListNode meetNode = null;
            while (fast.next!=null&&fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast){
                    return true;
                }
            }
            //若出现了等于null，则表示链表无环
            return false;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);//
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next = head.next.next;

        boolean has = Solution.hasCycle(head);

        System.out.println(has);
    }


}
