package 设计模式.模式.装饰者模式.测试一;

public class Decorate1 extends Decorate {

	Decorate1(Human human) {
		super(human);
	}
	
	public void goHome() {  
        System.out.println("进房子。。");  
    }  
  
    public void findMap() {  
        System.out.println("书房找地图。。");  
    }  
  
    @Override  
    public void doWhat() {  
        super.doWhat();  
        findMap();  
    }  
  
    @Override  
    public void goWhere() {  
        super.goWhere();  
        goHome();  
    }  
	

}
