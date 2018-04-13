package 设计模式.模式.装饰者模式.测试一;

public class Decorate implements Human{

	Human human;
	
	Decorate(Human human){
		this.human = human;
	}
	
	@Override
	public void goWhere() {
		human.goWhere();
	}

	@Override
	public void doWhat() {
		human.doWhat();
	}

}
