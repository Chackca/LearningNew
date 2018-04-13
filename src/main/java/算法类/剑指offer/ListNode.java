package 算法类.剑指offer;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T val) {
		this.val = val;
		this.next = null;
	}
    
    @Override
    public String toString() {
    	StringBuilder SB = new StringBuilder();
    	SB.append("[");
    	for(ListNode<T> cur = this;; cur=cur.next){
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