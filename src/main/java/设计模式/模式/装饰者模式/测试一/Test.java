package 设计模式.模式.装饰者模式.测试一;

public class Test {
	
	public static void main(String[] args) {
		Human human = new Person();
		
		Decorate decorate = new Decorate2(new Decorate1(human));
		decorate.goWhere();
		decorate.doWhat();
	}
}
