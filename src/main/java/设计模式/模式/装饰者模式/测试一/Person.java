package 设计模式.模式.装饰者模式.测试一;

public class Person implements Human {

	@Override
	public void goWhere() {
		System.out.println("要去哪里呢");
	}

	@Override
	public void doWhat() {
		System.out.println("要做什么呢");
	}

}
