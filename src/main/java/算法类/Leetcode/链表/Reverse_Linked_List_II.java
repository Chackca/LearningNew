package 算法类.Leetcode.链表;

/**
 * 反转一个链表从m到n的元素。
 * 如对于链表1-2-3-4-5-null，m=2，n=4
 * 则返回链表1-4-3-2-5-null
 */
public class Reverse_Linked_List_II {
    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public String toString() {
            StringBuilder SB = new StringBuilder();
            SB.append("[");
            for(ListNode cur = this;; cur=cur.next){
                if(cur == null){
                    SB.deleteCharAt(SB.lastIndexOf(","));
                    //SB.deleteCharAt(SB.lastIndexOf(""));
                    break;
                }
                SB.append(cur.val);
                SB.append(",");
            }
            SB.append("]");
            return SB.toString();
        }
    }

    private static ListNode reverseListFromMtoN(ListNode head, int m, int n) {
        if (head == null || head.next==null || m>=n )
            return null;

        ListNode head1 = head;
        ListNode pre = null;
        ListNode cur = head;
        int index = 1;


        while (cur!=null){
            ListNode next = null;
            if (index==m){
                ListNode tempPre = pre;//null
                ListNode tail = cur;//head
                while (index>=m&&index<=n){
                    next = cur.next;

                    if (index == m) {
                        cur.next = null;//
                    }else {
                        cur.next = pre;
                    }
                    pre = cur;
                    cur = next;

                    index++;
                    if (index == n){
                        if (tempPre!=null) tempPre.next = cur;
                        else head = cur;
                        tail.next = cur.next;
                    }
                }

                return head;
            }else {
                index++;
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(head);
        System.out.println(reverseListFromMtoN(head,1,5));
    }

}
