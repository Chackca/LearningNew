package 算法类.剑指offer;

import java.util.Stack;
/**
 * @Author Chackca
 * @Date 2018/9/13 19:09
 * @Description :
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 **/
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

	/*public static boolean isPopOrder(int [] pushA,int [] popA) {
		if (pushA == null || popA == null || pushA.length != popA.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int indexPush = 0;
		int indexPop = 0;
		while (indexPop<popA.length){
			while (indexPush<pushA.length && indexPop<popA.length && pushA[indexPush] != popA[indexPop] ){
				stack.push(pushA[indexPush]);
				indexPush++;
			}
			if (indexPush<pushA.length && indexPop<popA.length && pushA[indexPush] == popA[indexPop] ){
				indexPush++;
				indexPop++;
				while (indexPop<popA.length && stack.size()!=0 && stack.peek() == popA[indexPop]){
					stack.pop();
					indexPop++;
				}
			}else{
				return false;
			}
		}
		if (indexPop==popA.length)
			return true;
		return false;
	}*/
}
