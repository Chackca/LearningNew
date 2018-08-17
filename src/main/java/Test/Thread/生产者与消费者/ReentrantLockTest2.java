package Test.Thread.生产者与消费者;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 此类为使用一个condition实现类似于wait notify的功能
 */
public class ReentrantLockTest2 {

    private static class Producer implements Runnable {
        int tryTimes = 0;
        private ReentrantLock lock;
        Condition notFull;
        Condition notEmpty;
        ArrayList list;
        Producer(ReentrantLock lock,Condition notEmpty,Condition notFull,ArrayList list){
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes<10){
                try {
                    lock.lock();
                    tryTimes++;
                    System.out.println("生产线程生产了"+tryTimes);
                    list.add(tryTimes);
                    notEmpty.signal();
                    notFull.await();
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
        Condition notFull;
        Condition notEmpty;
        Consumer(ReentrantLock lock,Condition notEmpty,Condition notFull,ArrayList list){
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes<10){
                try {
                    lock.lock();
                    if (list.size()!=0)
                    tryTimes++;
                    System.out.println("消费线程消费了"+tryTimes);
                    list.remove(0);
                    notFull.signal();
                    notEmpty.await();
                }catch (Exception e){

                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();

        ArrayList list = new ArrayList();
        Producer producer = new Producer(lock,notEmpty,notFull,list);
        Consumer consumer = new Consumer(lock,notEmpty,notFull,list);
        Thread prod =new Thread(producer);
        Thread cons =new Thread(consumer);
        prod.start();
        cons.start();
    }


}
