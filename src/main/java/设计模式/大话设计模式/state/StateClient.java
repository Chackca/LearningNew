package 设计模式.大话设计模式.state;

/**
 * 客户端：不断请求，不断更改状态
 * 
 * @author liu yuning
 *
 */
//客户端：不断请求，不断更改状态
public class StateClient {
    public static void main(String[] args) {
		Context context = new Context(new ConcreteStateA());
		context.request();
		context.request();
		context.request();
		context.request();
		context.request();
    }
}
