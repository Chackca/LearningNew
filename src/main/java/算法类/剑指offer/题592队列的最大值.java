package 算法类.剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 题592队列的最大值 {
	
	public static class QueueWithMax<T extends Comparable> {
		//队列里面存储的值为索引与当前索引对应的值
		
		// 这个队列里面有两个双向队列，一个存储队列元素，一个存储当前队列最大值
		 
        private Deque<InternalData<T>> queueData;
        private Deque<InternalData<T>> queueMax;
        private int currentIndex;
        
        
        public QueueWithMax() {
            this.queueData = new ArrayDeque<>();
            this.queueMax = new ArrayDeque<>();
            this.currentIndex = 0;
        }
        
        public T max(){
            if(queueMax.isEmpty())
                return null;
            return queueMax.getFirst().value;
        }
        
        public void pushBack(T value){
        	//若要插入的值大于存储最大值的队列的队尾元素，则将其队尾元素移除
            while (!queueMax.isEmpty()&&value.compareTo(queueMax.getLast().value)>=0)
                queueMax.removeLast();
            InternalData<T> addData = new InternalData<>(value,currentIndex);
            queueMax.addLast(addData);
            queueData.addLast(addData);
            currentIndex++;
        }
        
        public T popFront(){
            if(queueData.isEmpty())
                return null;
            InternalData<T> delData = queueData.removeFirst();
            if(delData.index==queueMax.getFirst().index)
                queueMax.removeFirst();
            return delData.value;
        }
        
        private static class InternalData<M extends Comparable> {
            public M value;
            public int index;
            public InternalData(M value,int index){
                this.value = value;
                this.index = index;
            }
        }
    }

	
	
    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        //队尾进
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(1);
        System.out.println(queue.max());
        
        System.out.println("开始出队后，调用max");
        
        System.out.println(queue.max());
        //队头出
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());
        queue.popFront();
        System.out.println(queue.max());


    }
}
