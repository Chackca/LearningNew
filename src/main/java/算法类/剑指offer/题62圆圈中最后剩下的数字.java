package 算法类.剑指offer;
/*
 * Description:圆圈中最后剩下的数字
 * n=5,m=3,从0,1,2,3,4组成的圆中删除第3个数字
 * 依次删除3,0,4,1，最终剩下的是3
 */
public class 题62圆圈中最后剩下的数字 {
	
	private static int lastRemaining(int n, int m) {
		if(n<1||m<1)
            return -1;
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> cur = head;
        for(int i=1;i<n;i++){
            ListNode<Integer> node = new ListNode<>(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        cur = head;
        while (true){
            //长度为1结束循环
            if(cur.next==cur)
                return cur.val;
            //向后移动
            for(int i=1;i<m;i++)
                cur=cur.next;
            //删除当前节点
            cur.val = cur.next.val;
            cur.next = cur.next.next;
            //删除后，cur停在被删节点的后一节点处
        }


	}
	
	public static void main(String[] args){
		//0.1.2.3.4.5   2
		//->0.1.3.4.5   0
		//->1.3.4.5     4
		//->1.3         1
		//->3
        System.out.println(lastRemaining(5,3)); //3
        System.out.println(lastRemaining(6,7)); //4
        System.out.println(lastRemaining(0,7)); //-1
    }

	
}
