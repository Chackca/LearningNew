package 算法类.剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 题591滑动窗口的最大值 {
	//把可能会成为最大值的下标存储下来，从而降低扫描次数
    public static int[] maxInWindows(int[] data,final int size){
        if(data==null ||data.length==0||data.length<size)
            return new int[0];
        //结果集=8-3+1=6个元素
        int[] result = new int[data.length-size+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<size-1;i++){//循环三次
        	//第一次队列为空，不进入，第二次进入了
            while (!deque.isEmpty()&&data[i]>=data[deque.getLast()])
                deque.removeLast();
            //将0添加到队列尾
            deque.addLast(i);
        }//初始化i=2，i<8，i++
        for(int i=size-1;i<data.length;i++){
        	//当队列不为空，并且i-队头元素+1>3
        	//当当前窗口超过了之前队头的元素时，将队头元素移除
            while (!deque.isEmpty()&&i-deque.getFirst()+1>size)
                deque.removeFirst();
            //当队列不为空，并且data[队尾元素]<data[i]
            //当队尾元素小于最新进入窗口的元素时，将队尾元素移除
            while (!deque.isEmpty()&&data[deque.getLast()]<=data[i])
                deque.removeLast();
            //将当前循环的下标添加到队尾
            deque.addLast(i);
            //存储每一个结果集
            result[i-(size-1)] = data[deque.getFirst()];
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{2,3,4,2,6,2,5,1};
        int[] result = maxInWindows(data,3);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("\t");
	    }
	}

}
