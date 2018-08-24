package Test.Thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 自制线程池
 */
public class DiyThreadExecutor {
    //创建
    private volatile boolean RUNNING = true;

    //所有任务都放队列中，让工作线程来消费
    private static BlockingQueue<Runnable> queue = null;

    private final HashSet<Worker> workers = new HashSet<Worker>();//存储当前的工作线程，便于统一中断

    private final List<Thread> threadList = new ArrayList<Thread>();

    //工作线程数
    int poolSize = 0;
    //核心线程数（创建了多少个工作线程）
    int coreSize = 0;

    boolean shutdown = false;

    public DiyThreadExecutor(int poolSize){
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null) throw new NullPointerException();
        if(coreSize < poolSize){
            addThread(runnable);
        }else{
            //System.out.println("offer" +  runnable.toString() + "   " + queue.size());
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 预热，添加到阻塞队列的同时运行此线程，这个方法只会被调用coreSize次
     * @param runnable
     */
    public void addThread(Runnable runnable){
        coreSize ++;//当预热后，以后将不会再执行此方法了
        //创建worker，让每一个worker不断循环取队列中的任务
        Worker worker = new Worker(runnable);//放到BlockingQueue中
        workers.add(worker);//存储到工作线程
        Thread t = new Thread(worker);//构建coreSize个环境以运行worker
        threadList.add(t);
        try {
            t.start();//从BlockingQueue中取出数据，内部是循环取数据
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void shutdown() {
        RUNNING = false;
        if(!workers.isEmpty()){
            for (Worker worker : workers){
                worker.interruptIfIdle();//调用一次就行，其内部会遍历所有的工作线程并停掉他们
                break;
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }



    private class Worker implements Runnable{
        public Worker(Runnable runnable){
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (true && RUNNING){
                if(shutdown == true){
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread :threadList) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DiyThreadExecutor excutor = new DiyThreadExecutor(3);
        for (int i = 0; i < 10; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            });
        }
        excutor.shutdown();
    }
}
