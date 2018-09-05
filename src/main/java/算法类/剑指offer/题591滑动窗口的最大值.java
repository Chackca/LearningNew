package 算法类.剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目要求：
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
 * 例如，输入数组{2,3,4,2,6,2,5,1}和数字3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 *
 * 思路3：把可能成为最大值数字的下标放入双端队列deque，从而减少遍历次数。
 * 首先，所有在没有查看后面数字的情况下，任何一个节点都有可能成为某个状态的滑动窗口的最大值，
 * 因此，数组中任何一个元素的下标都会入队。关键在于出队，以下两种情况下，
 * 该下标对应的数字不会是窗口的最大值需要出队：(1)该下标已经在窗口之外，
 * 比如窗口长度为3，下标5入队，那么最大值只可能在下标3,4,5中出现，
 * 队列中如果有下标2则需要出队；(2)后一个元素大于前面的元素，那么前面的元素出对，
 * 比如目前队列中有下标3、4，data[3] = 50,data[4]=40，下标5入队，但data[5] = 70，
 * 则队列中的3，4都需要出队。
 * 数组{2,3,4,2,6,2,5,1}的长度为3的滑动窗口最大值求解步骤如下
 *
 * 步骤    插入数字    滑动窗口    队列中的下标   最大值
 * 1       2          2           0(2)          N/A
 * 2       3          2,3         1(3)          N/A
 * 3       4          2,3,4       2(4)          4
 * 4       2          3,4,2       2(4),3(2)     4
 * 5       6          4,2,6       4(6)          6
 * 6       2          2,6,2       4(6),5(2)     6
 * 7       5          6,2,5       4(6),6(5)     6
 * 8       1          2,5,1       6(5),7(1)     5
 * 时间复杂度在o(n)~o(nk)之间，空间复杂度o(k)。
 */
public class 题591滑动窗口的最大值 {
	//把可能会成为最大值的下标存储下来，从而降低扫描次数
    public static int[] maxInWindows(int[] data,final int size){
        if(data==null ||data.length==0||data.length<size)
            return new int[0];
        //结果集=8-3+1=6个元素
        int[] result = new int[data.length-size+1];
        Deque<Integer> deque = new ArrayDeque();

        for(int i=0;i<size;i++){//循环三次
        	//第一次队列为空，不进入，第二次进入了
            while (!deque.isEmpty()&&data[i]>=data[deque.getLast()])
                deque.removeLast();
            //将0添加到队列尾
            deque.addLast(i);
        }//初始化i=2，i<8，i++
        for(int i=size-1;i<data.length;i++){
        	//当队列不为空，并且i-队头元素+1>3
        	//当当前窗口超过了之前队头的元素时，将队头元素移除
            if (!deque.isEmpty()&&i-deque.getFirst()+1>size)
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
