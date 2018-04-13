package 设计模式.大话设计模式.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚集类
 * 
 * @author liu yuning
 *
 * @param <T>
 */
//具体聚集类
public class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> items = new ArrayList<T>();
    @Override
    public Iterator<T> createIterator() {
	    return new ConcreteIterator<T>(this);
    }
    public int count() { return items.size(); }
    public T getItems(int index) { return items.get(index); }
    public void setItems(T item) { items.add(item); }
}
