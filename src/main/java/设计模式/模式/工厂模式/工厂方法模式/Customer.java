package 设计模式.模式.工厂模式.工厂方法模式;
public class Customer {  
    public static void main(String[] args) {  
        FactoryBMW factoryBMW320 = new FactoryBMW320();  
        BMW320 bmw320 = (BMW320) factoryBMW320.createBMW();  

        FactoryBMW factoryBMW523 = new FactoryBMW523();  
        BMW523 bmw523 = (BMW523) factoryBMW523.createBMW();  
    }  
}  