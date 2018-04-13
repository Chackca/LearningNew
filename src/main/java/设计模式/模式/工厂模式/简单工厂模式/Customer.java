package 设计模式.模式.工厂模式.简单工厂模式;
public class Customer {  
    public static void main(String[] args) {  
        Factory factory = new Factory();  
        BMW bmw320 = factory.createBMW(320);  
        BMW bmw523 = factory.createBMW(523);  
    }  
}  