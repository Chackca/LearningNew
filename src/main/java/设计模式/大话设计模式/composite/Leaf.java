package 设计模式.大话设计模式.composite;

import 设计模式.大话设计模式.util.StringUtil;

/**
 * Leaf在组合中表示叶节点对象，叶节点没有子节点
 * 
 * @author liu yuning
 *
 */
//Leaf在组合中表示叶节点对象，叶节点没有子节点
public class Leaf extends Component {
    public Leaf(String name) {
	super(name);
    }
    public void add(Component component) {
	System.out.println("cannot add to a leaf");
    }
    public void remove(Component component) {
	System.out.println("cannot remove from a leaf");
    }
    public void display(int depth) {
	// 通过“-”的数目显示级别
	System.out.println(StringUtil.repeatableString("-", depth) + this.name);
    }
}
