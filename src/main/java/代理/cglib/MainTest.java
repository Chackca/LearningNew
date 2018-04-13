package 代理.cglib;


public class MainTest {
	
	
	
	public static void main(String[] args) {
		//创建一个目标类
		AimObject object = new AimObject();
		//创建一个拦截器
		MyInterceptor myInterceptor = new MyInterceptor(object);
		
		AimObject Proxy = (AimObject) myInterceptor.createProxy();
		
		Proxy.aimMethod();
		
	}
}
