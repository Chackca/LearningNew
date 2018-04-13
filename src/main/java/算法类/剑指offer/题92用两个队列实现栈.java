package 算法类.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class 题92用两个队列实现栈 {
	
	public static class MyStack<Integer>{

		Queue<Integer> A = new LinkedList<Integer>();
		Queue<Integer> B = new LinkedList<Integer>();
		
		
		public void push(Integer data) {
			if (A.size() ==0 && B.size() ==0) A.offer(data);
			else if (A.size() !=0 && B.size() ==0) A.offer(data);
			else if (A.size() ==0 && B.size() !=0) B.offer(data);
			else {
				System.out.println("出错啦");
			}
		}

		public Integer pop() {
			if (B.size()==0) {
				if (A.size()==1) return A.poll();
				else {
					if (A.size()==0) return null;
					while (A.size()!=1) {
						B.offer(A.poll());
					}return A.poll();			
				}
			}
			else if (A.size()==0) {
				if (B.size()==1) return B.poll();
				else {
					if (B.size()==0) return null;
					while (B.size()!=1) {
						A.offer(B.poll());
					}return B.poll();			
				}
			}
			return null;
		}
		
	}
	
	public static void main(String[] args){
        MyStack<Integer> myStack = new MyStack<Integer>();
        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
