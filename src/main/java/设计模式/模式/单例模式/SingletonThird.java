package 设计模式.模式.单例模式;
/*
 * 线程安全的单例模式
 */
public class SingletonThird {
	private SingletonThird() {}  //私有构造函数
	private volatile static SingletonThird instance = null;  //单例对象
	//静态工厂方法
	public static SingletonThird getInstance() {
		if (instance == null) {      //双重检测机制synchronized (Singleton.class){  //同步锁
			synchronized (SingletonThird.class){  //同步锁
				if (instance == null) {     //双重检测机制
					instance = new SingletonThird();
				}
			}
		}
		return instance;
	}
}
