package 算法类.剑指offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */

public class 题91用两个栈实现队列 {
	
	/*
	 * A栈与B栈
	 * 进队列入A栈
	 * 出队列时若B栈为空将A栈的所有值弹出进B栈，再弹出B栈顶层，若不为空直接弹出栈顶
	 * 
	 */
	static class MyQueue<Integer>{
		
		Stack<Integer> A = new Stack<Integer>();
		Stack<Integer> B = new Stack<Integer>();
		
		public Integer poll() {
			if (B.isEmpty()) {
				if (A.isEmpty()) {
					System.out.print("无数据可删除");
					return null;
				}
				while(!A.isEmpty()){
					B.push(A.pop());
				}
			}
			return B.pop();
		}
		
		public void offer(Integer data) {
			A.push(data);
		}
	}
	
	
	
    public static void main(String[] args){
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        System.out.println(myQueue.poll());
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.offer(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
