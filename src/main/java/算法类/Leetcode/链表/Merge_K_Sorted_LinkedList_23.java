package 算法类.Leetcode.链表;

import 算法类.domain.ListNode;

/**
 * 有k个有序数组，将他们归并为1个有序数组
 *
 *  初见之下，最容易想到的方法是“归并排序”（Merging Sort）：
 *  将两个或两个以上的有序表组合成一个新的有序表，无论是顺序存储结构还是链式存储结构，
 *  对于任何两个长度分别为m和n的有序表，其组合都可在O(m+n)的时间复杂度量级上完成。
 *  对于K个有序表，假设共有N个元素，且这些有序表初始状态都不为空，
 *  每个有序表平均拥有N/K个元素。最常用的方法是采用“二分”的思想进行两两合并：
 *  第一轮循环，有序表lists[0]与lists[(K+1)/2]，
 *  lists[1]与lists[(K+1)/2+1]，lists[2]与lists[(K+1)/2+2]....，
 *  lists[K/2-1]与lists[K-1]。这样K个有序表就被组合成了K/2个有序表；
 *  第二轮循环后将减少为K/4个有序表；直到组合成一个具有N个元素的有序表。
 *  总的时间复杂度：O(NKlogK)。
 */
public class Merge_K_Sorted_LinkedList_23 {

    public ListNode mergeKLists(ListNode[] lists)
    {
        int len=lists.length;

        if(lists==null||len==0)
            return null;
        if(len==1)
            return lists[0];

        while(len>1)//基于“二分”思想进行链表的两两组合
        {
            int mid=(len+1)/2;//二分
            for(int i=0;i<len/2;i++)
            {
                lists[i]=mergeTwoLists(lists[i],lists[i+mid]);
            }
            len=mid;
        }
        return lists[0];
    }
    //有序链表的组合，L1和L2为头结点，归并排序的核心思想
    public ListNode mergeTwoLists(ListNode L1,ListNode L2)
    {
        if(L1==null)return L2;
        if(L2==null)return L1;

        ListNode head=new ListNode(0);//保存结果的链表，头结点初始化
        ListNode phead=head;

        while(L1!=null&&L2!=null)//两个链表归并排序
        {
            if(L1.val <=L2.val)
            {
                phead.next=L1;//接入结果链表
                phead=phead.next;//移动指针
                L1=L1.next;
            }
            else
            {
                phead.next=L2;
                phead=phead.next;
                L2=L2.next;
            }
        }
        if(L1!=null)
            phead.next=L1;
        else
            phead.next=L2;

        return head.next;//初始化的第一个节点不属于结果
    }

}
