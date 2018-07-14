package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 给定一个链表中的节点，删除该节点
 * 注：难点在于无法拿到当前节点的前一个节点
 * 方法为：将下一个节点的值拷贝到当前节点，再删除下一个节点
 */
public class Delete_Node_In_a_LinkedList_237 {


    private static ListNode deleteNodeInaLinkedList(ListNode deleteNode) {
        if (deleteNode==null)
            return null;
        if (deleteNode.next == null) {
            deleteNode = null;
            return null;
        }

        ListNode next = deleteNode.next;
        deleteNode.val = next.val;
        deleteNode.next = next.next;
        return deleteNode;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,6,8,2,3,4,5,-1,-2,0,9};
        ListNode head = ListNode.createListNode(arr);
        System.out.println(deleteNodeInaLinkedList(head));
    }

}

