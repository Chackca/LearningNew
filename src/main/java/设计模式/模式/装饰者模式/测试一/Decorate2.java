package 设计模式.模式.装饰者模式.测试一;

public class Decorate2 extends Decorate {

	Decorate2(Human human) {
		super(human);
	}
	
	public void goBook() {  
        System.out.println("进房子了，接下来进书房");  
    }  
  
    public void lookMap() {  
        System.out.println("书房找到地图了，接下来看地图");  
    }  
  
    @Override  
    public void doWhat() {  
        super.doWhat();  
        lookMap();  
    }  
  
    @Override  
    public void goWhere() {  
        super.goWhere();  
        goBook();  
    }  
	

}
