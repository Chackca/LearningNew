package 算法类.domain;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        StringBuilder SB = new StringBuilder();
        SB.append("[");
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
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

    public static ListNode createListNode(int arr[]) {
        if (arr.length==0 || arr==null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1 ; i < arr.length ; i++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }
}