package 设计模式.大话设计模式.builder;

/**
 * 指挥者类，用来指挥建造过程
 * 
 * @author liu yuning
 *
 */
//指挥者类，用来指挥建造过程
public class Director {
    public void construct(Builder builder) {
    	builder.buildPartA();
		builder.buildPartB();
    }
}
