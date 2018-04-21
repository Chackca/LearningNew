package Test.死锁;

public class Main {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();


    public static void main(String[] args) {
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
    }


    static class MyThread1 implements Runnable{
        @Override
        public void run() {
            try {
                synchronized (obj1){
                    System.out.println("线程1获取了obj1的锁");
                    Thread.sleep(500);
                    System.out.println("线程1尝试获取obj2的锁中");
                    synchronized (obj2){
                        System.out.println("线程1成功获取obj2的锁");

                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            try {
                synchronized (obj2){
                    System.out.println("线程2获取了obj2的锁");
                    Thread.sleep(500);
                    System.out.println("线程2尝试获取obj1的锁中");
                    synchronized (obj1){
                        System.out.println("线程2成功获取obj1的锁");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
