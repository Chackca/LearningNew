package Test.代理.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler{

	private Object obj;

	public MyInterceptor(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("切面方法a()");//切面方法a();
	    
	    method.invoke(this.obj, args);//调用目标类的目标方法  
	        
	    System.out.println("切面方法f()");//切面方法f();
	   
		return null;
	}
	

}
