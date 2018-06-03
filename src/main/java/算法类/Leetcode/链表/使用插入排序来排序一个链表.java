package 算法类.Leetcode.链表;

/**
 * Sort a linked list using insertion sort.
 * 使用插入排序来排序一个链表
 */
public class 使用插入排序来排序一个链表 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(8);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(3);
        ListNode res = Solution.insertionSortList(node);
        System.out.println();
    }

    public static class Solution {


        public static ListNode insertionSortList(ListNode head) {
            //新链表的头(-1)，用于辅助定位新链表头
            ListNode temp = new ListNode(Integer.MIN_VALUE);
            //新链表的头(0)
            ListNode pre ;
            ListNode cur = head;
            while (cur !=null){
                ListNode next = cur.next;
                pre = temp;

                //从头到尾遍历新链表，若找到链表尾，或者找到链表中有节点的值小于当前在定位的节点cur的值
                while (pre.next!=null && pre.next.val<cur.val){
                    pre = pre.next;
                }

                //将当前节点插入到新链表的正确位置
                cur.next = pre.next;
                pre.next = cur;

                //处理后继节点
                cur = next;
            }
            return temp.next;
        }
    }
}
