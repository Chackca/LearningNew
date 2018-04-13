package 设计模式.模式.享元模式;
public class ConcreteFlyweight extends Flyweight{  
	private String string;  
	public ConcreteFlyweight(String str){  
		string = str;  
	}  
	public void operation(){
		System.out.println("Concrete---Flyweight : " + string);  
	}  
}  