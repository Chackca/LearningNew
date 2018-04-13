package 设计模式.模式.单例模式;
/*
 * 用静态内部类实现的单例模式
 */
public class SingletonFourth {
	private SingletonFourth (){}
	
	private static class LazyHolder {
        private static final SingletonFourth INSTANCE = new SingletonFourth();
    }
   
    public static SingletonFourth getInstance() {
        return LazyHolder.INSTANCE;
    }

}
/*
 * 利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。
 */
