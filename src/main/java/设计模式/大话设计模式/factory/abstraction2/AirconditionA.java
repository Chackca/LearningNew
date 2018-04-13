package 设计模式.大话设计模式.factory.abstraction2;

public class AirconditionA implements Aircondition{
    public AirconditionA(){    
        System.out.println("制造-->AirconditionA");    
    }    
}

class AirconditionB implements Aircondition{
    public AirconditionB(){
        System.out.println("制造-->AirconditionB");
    }
}