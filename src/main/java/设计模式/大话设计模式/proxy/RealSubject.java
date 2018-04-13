package 设计模式.大话设计模式.proxy;

/**
 * 真实实体类
 * 
 * @author liu yuning
 *
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
	System.out.println("真实对象的请求");
    }
}
