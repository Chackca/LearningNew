package 设计模式.大话设计模式.builder;

/**
 * 具体建造者类
 * 
 * @author liu yuning
 *
 */
//具体建造类
public class ConcreteBuilder1 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
	product.add("部件A");
    }
    @Override
    public void buildPartB() {
	product.add("部件B");
    }
    @Override
    public Product getBuildResult() {
	return product;
    }
}
