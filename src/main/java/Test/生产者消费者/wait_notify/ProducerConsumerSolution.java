package Test.生产者消费者.wait_notify;

import java.util.Vector;

public class ProducerConsumerSolution {
    public static void main(String[] args) {  
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue,size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue,size), "Consumer");
        prodThread.start();  
        consThread.start();  
    }  
}  