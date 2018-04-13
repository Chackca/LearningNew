package 设计模式.大话设计模式.memento;

/**
 * 备忘录（Memento）类
 * 
 * @author liu yuning
 *
 */

public class Memento {
    private String state;

    public Memento(String state) {
	this.state = state;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

}
