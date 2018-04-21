package Test.死锁;

public class Main2 {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(new MyThread1(obj1,obj2),"线程1").start();
        new Thread(new MyThread1(obj2,obj1),"线程2").start();
    }

    static class MyThread1 implements Runnable{
        Object obj1 ;
        Object obj2 ;

        MyThread1(Object obj1,Object obj2){
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            try {
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+"获取了obj1的锁");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+"尝试获取obj2的锁中");
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+"成功获取obj2的锁");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
