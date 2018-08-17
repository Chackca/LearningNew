package Test.Thread.生产者与消费者;

import java.util.ArrayList;

public class WaitNotify {



    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        Thread prod =new Thread(producer);
        Thread cons =new Thread(consumer);
        prod.start();
        cons.start();
    }





    private static class Producer implements Runnable{
        int tryTimes = 0;
        ArrayList list ;
        public Producer(ArrayList list){
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes!=10){
                synchronized (list){
                    if (list.size()==3){
                        System.out.println("生产者进入等待状态");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        tryTimes++;
                        list.add(1);
                        System.out.println("生产第"+tryTimes+"份烤肉");
                        list.notify();
                    }
                }
            }

        }
    }



    private static class Consumer implements Runnable{
        int tryTimes = 0;
        ArrayList list ;
        public Consumer(ArrayList list){
            this.list = list;
        }

        @Override
        public void run() {
            while (tryTimes!=10){
                synchronized (list){
                    if (list.size()==0){
                        System.out.println("消费者进入等待状态");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        tryTimes++;
                        list.remove(0);
                        System.out.println("消费了第"+tryTimes+"份烤肉");
                        list.notify();
                    }
                }
            }
        }
    }
}

