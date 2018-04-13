package 线程.创建线程;

/*
 * 	1.重写run方法。该run（）方法的方法体就代表了线程需要完成的任务。 
	2.创建Thread子类的实例。 
	3.调用线程对象的start（）方法来启动该线程。
 */

public class 继承Thread类  extends Thread{
	private int i;
    public void run()
    {
        for(;i<100;i++)
        {
            System.out.println(getName()+" "+i);
        }
    }


    public static void main(String[] args) 
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                new 继承Thread类().start();
                new 继承Thread类().start();
            }
        }
    }
}
