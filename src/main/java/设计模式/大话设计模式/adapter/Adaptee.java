package 设计模式.大话设计模式.adapter;

/**
 * 需要适配的类
 * 
 * @author Chackca
 *
 */
//需要适配的类
public class Adaptee {
    public void specificRequest() {
	System.out.println("特殊的请求！");
    }
}
