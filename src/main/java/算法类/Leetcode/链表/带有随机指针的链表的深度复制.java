package 算法类.Leetcode.链表;

/**
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 Return a deep copy of the list.

 给出了一个链表，每个节点都包含一个额外的随机指针，它可以指向列表中的任何节点或null。
 返回这个链表的深层副本。
 */
public class 带有随机指针的链表的深度复制 {

        //Definition for singly-linked list with a random pointer.
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static class Solution {
        public static RandomListNode copyRandomList(RandomListNode head) {
            if (head == null || head.next == null)
                return head;

            RandomListNode cur = head;
            while (cur!=null){
                RandomListNode node = new RandomListNode(cur.label);
                RandomListNode next = cur.next;
                cur.next = node;
                node.next = next;
                cur = next;
            }

            cur = head;
            while (cur!=null){
                RandomListNode node = cur.random;
                cur.next.random = node;
                cur=cur.next.next;
            }
            cur = head;
            RandomListNode newHead = head.next;
            RandomListNode newListNode = head.next;
            while (newListNode.next!=null){
                cur.next = newListNode.next;
                newListNode.next = cur.next.next;
                newListNode = newListNode.next;
                cur = cur.next;
            }
            cur.next = null;//以上循环退出以后，原链表的最后一个结点的仍然会指向最后一个节点的复制的节点，需要在这里将其指向空
            return newHead;
        }
    }


    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(2);
        node.next = new RandomListNode(1);
        node.next.next = new RandomListNode(5);
        node.next.next.next = new RandomListNode(8);
        node.next.next.next.next = new RandomListNode(4);
        node.next.next.next.next.next = new RandomListNode(3);
        RandomListNode res = Solution.copyRandomList(node);
        System.out.println();
    }
}
