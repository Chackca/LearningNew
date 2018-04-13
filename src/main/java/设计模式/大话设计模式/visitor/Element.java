package 设计模式.大话设计模式.visitor;

/**
 * 定义一个accept操作，它以一个访问者为参数
 * 
 * @author liu yuning
 *
 */
//定义一个accept操作，它以一个访问者为参数
public abstract class Element {
    public abstract void accept(Visitor visitor);
}

class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
	    visitor.visitConcreteElementA(this);
    }
}

class ConcreteElementB extends Element {
    @Override
    public void accept(Visitor visitor) {
	    visitor.visitConcreteElementB(this);
    }
}