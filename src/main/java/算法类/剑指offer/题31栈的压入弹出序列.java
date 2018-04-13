package 算法类.剑指offer;

import java.util.Stack;

public class 题31栈的压入弹出序列 {
	
	
	public static boolean isPopOrder(int[] in,int[] out) {
		int inLength = in.length;
		int outLength = out.length;
		if(inLength==0||outLength==0||inLength!=outLength)
			return false;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int inSeqIndex = 0,outSeqIndex = 0;
		
		for(inSeqIndex = 0;inSeqIndex<inLength;inSeqIndex++){
			stack.push(in[inSeqIndex]); //将压入序列的某一位压入栈
				
			//若当前压入栈的值==弹出序列的值
			while(stack.peek()==out[outSeqIndex]){ 
				outSeqIndex++;
				stack.pop();
				if(stack.isEmpty())
					break;
			}
		}
		if(outSeqIndex==inLength)
			return true;		
	
		return false;	
		
	}
	
	
	
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        int[] pop3 = {1,2,3,4,5};
        System.out.println(isPopOrder(push,pop1));
        System.out.println(isPopOrder(push,pop2));
        System.out.println(isPopOrder(push,pop3));
	}
}
