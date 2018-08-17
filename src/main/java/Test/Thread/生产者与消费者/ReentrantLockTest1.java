package Test.Thread.生产者与消费者;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 此类为使用一个condition实现类似于wait notify的功能
 */
public class ReentrantLockTest1 {

    private static class Producer implements Runnable {
        int tryTimes = 0;
        private ReentrantLock lock;
        Condition condition;
        ArrayList list;
        Producer(ReentrantLock lock,Condition condition,ArrayList list){
            this.lock = lock;
            this.condition = condition;
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes<10){
                try {
                    lock.lock();
                    if (list.size()<3){
                        tryTimes++;
                        System.out.println("生产线程生产了"+tryTimes);
                        list.add(tryTimes);
                        condition.signal();
                    }else {
                        condition.await();
                    }
                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        int tryTimes = 0;
        private ReentrantLock lock;
        ArrayList list;
        Condition condition;
        Consumer(ReentrantLock lock,Condition condition,ArrayList list){
            this.lock = lock;
            this.condition = condition;
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes<10){
                try {
                    lock.lock();
                    if (list.size()!=0){
                        tryTimes++;
                        System.out.println("消费线程消费了"+tryTimes);
                        list.remove(0);
                        condition.signal();
                    }else {
                        condition.await();
                    }
                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ArrayList list = new ArrayList();
        Producer producer = new Producer(lock,condition,list);
        Consumer consumer = new Consumer(lock,condition,list);
        Thread prod =new Thread(producer);
        Thread cons =new Thread(consumer);
        prod.start();
        cons.start();
    }


}
