package Test.Thread.生产者与消费者.Concurrent;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        //LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread prod =new Thread(producer);
        Thread cons =new Thread(consumer);
        prod.start();
        cons.start();

    }

    private static class Producer implements Runnable{
        int tryTimes = 0;
        ArrayBlockingQueue queue ;
        public Producer(ArrayBlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
             while (tryTimes!=10){
                try {
                    tryTimes++;
                    queue.put(1);
                    System.out.println("生产第"+tryTimes+"份烤肉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             }
        }
    }


    private static class Consumer implements Runnable{
        int tryTimes = 0;
        ArrayBlockingQueue queue ;
        public Consumer(ArrayBlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (tryTimes!=10){
                try {
                    tryTimes++;
                    queue.take();
                    System.out.println("消费了第" + tryTimes + "份烤肉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
