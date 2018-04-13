package 算法类.剑指offer;

import java.util.HashMap;

/*
 * 在复杂链表中，每个节点除了有一个next指针指向下一个节点，
 * 还有一个random指针指向链表中的任意节点或null，
 * 请完成一个能够复制复杂链表的函数。
 */
public class 题35复杂链表的复制 {
	
	//解法一
    //time:o(n^2) space:o(1) 新链表使用的n个长度的空间不算入
    //先复制val与next（时间o(n)），再复制random域（时间o(n^2)）
	private static ComplexListNode clone1(ComplexListNode head) {
		if(head==null)
	         return null;
	    ComplexListNode newHead = new ComplexListNode(head.val);
	    ComplexListNode newRoot = newHead;

	    ComplexListNode cur = head;
	    ComplexListNode newCur = newHead;
	    //复制所有链表节点，不含random指针
	    while (cur.next!=null) {
			cur=cur.next;
			newHead.next = new ComplexListNode(cur.val);
			newHead = newHead.next;
		}
	    cur = head;
	    newCur = newRoot;
	    ComplexListNode temp = head;
	    ComplexListNode newTemp = newRoot;
	    while (cur!=null) {
	    	if (cur.random!=null) {
	    		temp = head;
		    	newTemp = newRoot;
	    		while (temp.next != cur.random) {
	    			temp = temp.next;
		    		newTemp= newTemp.next;
				}if (temp.next == cur.random) {
					newCur.random = newTemp.next;
				}
			}
	    	cur = cur.next;
	    	newCur = newCur.next;   	
		}
		return newRoot;
	}
	
	
	//解法二
    //time:o(n) space:o(n)
    //使用o(n)的空间，换取了时间复杂度的降低
    public static ComplexListNode clone2(ComplexListNode head) {
        if(head==null)
            return null;
        HashMap<ComplexListNode,ComplexListNode> oldToNew = new HashMap<>();
        ComplexListNode newHead = new ComplexListNode(head.val);
        oldToNew.put(head,newHead);
        ComplexListNode cur = head.next;
        ComplexListNode newCur = null;
        ComplexListNode newCurPrev = newHead;
        while (cur!=null){
            newCur = new ComplexListNode(cur.val);
            oldToNew.put(cur,newCur);
            newCurPrev.next = newCur;
            newCurPrev = newCurPrev.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            if(cur.random!=null){
                newCur.random = oldToNew.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    //解法三
    //time:o(n) space:o(1)
    public static ComplexListNode clone3(ComplexListNode head) {
        if(head==null)
            return null;
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }
    
    private static void cloneNodes(ComplexListNode head) {
    	ComplexListNode cur = head;
		while (cur!=null) {
			ComplexListNode newCur = new ComplexListNode(cur.val);	
			newCur.next = cur.next;
			cur.next = newCur;
			cur = newCur.next;
		}
		//System.out.println(head);
	}
	
	private static void connectRandomNodes(ComplexListNode head) {
		ComplexListNode newHead = head.next;
		ComplexListNode cur = head;
		ComplexListNode newCur = newHead;
		
		while (true) {
			while (cur!=null&&cur.random!=null) {
				newCur = cur.next;
				newCur.random = cur.random.next;
				cur = cur.next.next;
			}if (cur.next.next!=null) {
				cur = cur.next.next;
			}else {
				break;
			}
		}
		//System.out.println(head);
	}
	
	private static ComplexListNode reconnectNodes(ComplexListNode head) {
		ComplexListNode newHead = head.next;
		ComplexListNode cur = head;
		ComplexListNode newCur = newHead;
		
		while (cur!=null) {		
			cur.next = newCur.next;
			if (cur.next!=null) {
				newCur = cur.next.next;
			}else {
				
			}
			cur=cur.next;	
		}
		//System.out.println(newHead);
		return newHead;
	}


	public static void main(String[] args){
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("clone1:  "+'\t'+clone1(head));
        System.out.println("clone2:  "+'\t'+clone2(head));
        System.out.println("clone3:  "+'\t'+clone3(head));
    }


	public static class ComplexListNode{
        int val;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ComplexListNode cur = this;
            while(cur!=null) {
                ret.append(cur.val);
                if(cur.random!=null)
                    ret.append("("+cur.random.val+")");
                else{
                    ret.append("(_)");
                }
                ret.append('\t');
                cur = cur.next;
            }
            return ret.toString();
        }
    }
	
}
