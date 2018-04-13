package 设计模式.大话设计模式.iterator;

/**
 * 聚集接口
 * 
 * @author liu yuning
 *
 * @param <T>
 */

//聚集接口
public interface Aggregate<T> {
    public Iterator<T> createIterator();
}
