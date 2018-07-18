package 设计模式.大话设计模式.bridge;

/**
 * 
 * @author Chackca
 *
 */
public abstract class Abstraction {
    //桥接模式的关键，使得Abstraction聚合Implementor
    protected Implementor implementor;//聚合关系
    private String name;
    public Abstraction(String name) {
	    this.setName(name);
    }
    public void setImplementor(Implementor implementor) {
	    this.implementor = implementor;
    }
    public void operation() {
	    System.out.print("Abstraction-" + this.getName() + ": ");
	    implementor.operation();
    }
    public String getName() {
	    return name;
    }
    public void setName(String name) {
	    this.name = name;
    }
}

class AbstractionA extends Abstraction {
    public AbstractionA(String name) {
	    super(name);
    }
    @Override
    public void operation() {
	    super.operation();
    }
}

class AbstractionB extends Abstraction {
    public AbstractionB(String name) {
	    super(name);
    }
    @Override
    public void operation() {
	    super.operation();
    }
}
