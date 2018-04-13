package 设计模式.模式.单例模式;
/*
 * 线程不安全的单例模式
 */
public class SingletonFirst {
	//私有构造方法
	public SingletonFirst() {}
	//单例对象
	private static SingletonFirst instance = null;
	//静态工厂方法
	public static SingletonFirst getInstance() {
		if(instance == null){
			instance = new SingletonFirst();
		}
		return instance;
	}
	
}
