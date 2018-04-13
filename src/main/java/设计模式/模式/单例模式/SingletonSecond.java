package 设计模式.模式.单例模式;
/*
 * 线程较为安全的单例模式
 */
public class SingletonSecond {
	private SingletonSecond() {}  //私有构造函数
	private static SingletonSecond instance = null;  //单例对象
	//静态工厂方法
	public static SingletonSecond getInstance() {
		if (instance == null) {      //双重检测机制
			synchronized (SingletonSecond.class){  //同步锁
				if (instance == null) {     //双重检测机制
					instance = new SingletonSecond();
				}
			}
		}
		return instance;
	}
}
