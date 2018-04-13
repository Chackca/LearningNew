package 设计模式.大话设计模式.iterator;

/**
 * 迭代器接口
 * 
 * @author liu yuning
 *
 * @param <T>
 */
//迭代器接口
public interface Iterator<T> {
    public T first();
    public T next();
    public boolean isDone();
    public T currentItem();
}
