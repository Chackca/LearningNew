package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FieldDemo2 {
	public static void main(String[] args) throws Exception {
		//1,获取Class对象
		Class<?> c = Class.forName("domain.Person");
		//2，获取构造方法
		//public Person(String name) 
		Constructor con = c.getConstructor(String.class);
		//3，通过构造方法，创建对象
		Object obj = con.newInstance("小明");
		//4，获取指定的成员变量
		//public String name;
		Field nameField = c.getField("name");
		//public int age;
		Field ageField = c.getField("age");
		//private String address;
		Field addressField = c.getDeclaredField("address");
		addressField.setAccessible(true); //取消 Java 语言访问检查
		
		//5，通过方法，给指定对象的指定成员变量赋值或者获取值
		System.out.println("name = "+ nameField.get(obj));
		System.out.println("age = "+ ageField.get(obj));
		System.out.println("address = "+ addressField.get(obj));
		
		//赋值
		ageField.set(obj, 23);
		addressField.set(obj, "凯利广场");
		
		System.out.println("------------------------");
		System.out.println("name = "+ nameField.get(obj));
		System.out.println("age = "+ ageField.get(obj));
		System.out.println("address = "+ addressField.get(obj));
	}
}
