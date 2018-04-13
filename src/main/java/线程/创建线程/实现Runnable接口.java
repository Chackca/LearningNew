package 线程.创建线程;

/*
 * 	1.定义Runnable的实现类，重写run（）方法。 
	2.创建Runnable实现类的实例，
		并以此作为Thread的target来创建对象，该对象才是真正的线程对象。
 */
public class 实现Runnable接口 implements Runnable {
	private int i;
    public void run()
    {
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }


    public static void main(String[] args) 
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
            	实现Runnable接口 test=new 实现Runnable接口();
                new Thread(test,"新线程1").start();
                new Thread(test,"新线程2").start();
            }
        }
    }
}
