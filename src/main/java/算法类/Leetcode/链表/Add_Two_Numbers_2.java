package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

import java.util.Stack;

/**
 * 给出两个非空链表，表示两个非负整数
 * 其中每一个整数的各位以逆序存储
 * 返回这两个整数相加所代表的链表
 * 如342+465=807
 * 则给出2-4-3和5-6-4，返回7-0-8
 */
public class Add_Two_Numbers_2 {

    private static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if (list1==null || list2==null) return null;
        StringBuilder SB = new StringBuilder();
        while (list1!=null) {
            SB.append(list1.val);
            list1 = list1.next;
        }
        int num1 = Integer.parseInt(SB.reverse().toString());

        SB.delete(0,SB.length());

        while (list2!=null) {
            SB.append(list2.val);
            list2 = list2.next;
        }
        int num2 = Integer.parseInt(SB.reverse().toString());

        int result = num1+num2;
        SB.delete(0,SB.length());

        SB.append(result);

        ListNode head = null;
        ListNode cur ;
        ListNode pre = null;

        for (int i = 0 ; i < SB.length() ; i++) {
            if (i == 0) {
                head = new ListNode(result % 10);
                cur = head;
            }else {
                cur = new ListNode((int) (result / Math.pow(10,i) % 10));
                pre.next = cur;
            }
            pre = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,3};
        ListNode list1 = ListNode.createListNode(arr1);
        int[] arr2 = new int[]{5,6,4};
        ListNode list2 = ListNode.createListNode(arr2);
        System.out.println(addTwoNumbers(list1,list2));

    }


}
