package 设计模式.模式.单例模式;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectSingleton {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获得构造器
		Constructor<SingletonFourth> con = SingletonFourth.class.getDeclaredConstructor();
		//设置为可访问
		con.setAccessible(true);
		//构造两个不同的对象
		SingletonFourth singleton1 = (SingletonFourth)con.newInstance();
		SingletonFourth singleton2 = (SingletonFourth)con.newInstance();
		//验证是否是不同对象
		System.out.println(singleton1.equals(singleton2));
	}

}
