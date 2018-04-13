package 设计模式.大话设计模式.template;

/**
 * 具体类A
 * 
 * @author liu yuning
 *
 */
public class ConcreteClassA extends AbstractTemplate {
    @Override
    public void primitiveOperation1() {
	System.out.println("具体类A的方法1实现");
    }
    @Override
    public void primitiveOperation2() {
	System.out.println("具体类A的方法2实现");
    }
}
