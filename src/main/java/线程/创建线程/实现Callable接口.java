package 线程.创建线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
 *	1】创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。

	2】使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
	
	3】使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
	
	4】调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
 */
public class 实现Callable接口 implements Callable<String>{
	
	//重写call方法  
    @Override  
    public String call() throws Exception {  
    	//这里的返回值没有作出实际用途
        int i = 0;  
        String reString = "";  
        for (; i < 100; i++) {  
            reString = Thread.currentThread().getName() + " " + i;  
            System.out.println(reString);  
        }  
        return reString;  
    }  
	
	public static void main(String[] args) {  
		实现Callable接口 test=new 实现Callable接口();  
        FutureTask<String> ft=new FutureTask<>(test);  
          
        for (int i = 0; i < 100; i++) {  
            System.out.println(Thread.currentThread().getName()+" i的值为="+i);  
            if(i==20){  
                new Thread(ft,"子线程").start();  
            }  
        }  
    }  
}
