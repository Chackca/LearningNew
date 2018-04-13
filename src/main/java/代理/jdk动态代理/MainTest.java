package 代理.jdk动态代理;

import java.lang.reflect.Proxy;

public class MainTest {
	
	
	
	public static void main(String[] args) {
		AimImpl aimObject = new AimImpl();
		
		MyInterceptor interceptor = new MyInterceptor(aimObject);
		//生成代理对象，此代理对象实现了aimInterface接口
		AimInterface newProxyInstance = (AimInterface) Proxy.newProxyInstance(aimObject.getClass().getClassLoader(), aimObject.getClass().getInterfaces(), interceptor);
		
		newProxyInstance.aimMethod();
	}
}
