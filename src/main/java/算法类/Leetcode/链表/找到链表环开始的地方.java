package 算法类.Leetcode.链表;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
     Follow up:
    Can you solve it without using extra space?
     给定一个链表，返回循环开始的节点。如果没有循环，则返回null。
     跟进:
     你能在不使用额外空间的情况下解决吗？

    思路：一块一慢指针，两个指针相遇证明有环，记录当前点meetNode
        从头结点开始，两个指针，一个指针在head，另一个在meetNode，两个指针同步走，两个指针相遇即为环的开始
 */
public class 找到链表环开始的地方 {
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
        public static ListNode detectCycle(ListNode head) {
            if (head == null || head.next==null) return null;
            //1、一块一慢指针，两个指针相遇证明有环，记录当前点node
            ListNode slow = head;
            ListNode fast = head;
            ListNode meetNode = null;
            while (fast.next!=null&&fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast){
                    meetNode = slow;
                    break;
                }
            }
            //若出现了等于null，则表示链表无环
            if (fast.next==null||fast.next.next==null) return null;

            slow = head;
            fast = meetNode;

            while (slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);//
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next = head.next.next;

        ListNode circleInNode = Solution.detectCycle(head);

        System.out.println(circleInNode.val);
    }
}
