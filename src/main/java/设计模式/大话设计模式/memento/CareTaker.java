package 设计模式.大话设计模式.memento;

/**
 * 管理者（CareTaker）类：管理备忘录
 * 
 * @author liu yuning
 *
 */
//管理者（CareTaker）类：管理备忘录
public class CareTaker {
    private Memento memento;
    public Memento getMemento() { return memento; }
    public void setMemento(Memento memento) { this.memento = memento; }
}
