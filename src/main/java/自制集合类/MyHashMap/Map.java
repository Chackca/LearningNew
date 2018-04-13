package 自制集合类.MyHashMap;

public interface Map {

    int size();
    boolean isEmpty();
    Object get(Object key);
    Object put(Object key, Object value);
    interface Entry{
        Object getKey();
        Object getValue();

    }
}