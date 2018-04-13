package 代理.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor{
	
	private Object obj;
	
	
	public MyInterceptor(Object obj) {
		this.obj = obj;
	}

	
	 public Object createProxy() {  
         Enhancer enhancer = new Enhancer();  
         enhancer.setCallback(this);//回调函数  拦截器  
         //设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了。  
         enhancer.setSuperclass(this.obj.getClass());  
         return enhancer.create();  
     }  
	
	

	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		
		System.out.println("aaaaa");//切面方法a();  
	    
	    method.invoke(this.obj, args);//调用目标类的目标方法  
	        
	    System.out.println("bbbbb");//切面方法f();  
	   
		return null;
	}
	

}
