package 设计模式.大话设计模式.factory.abstraction2;

public class EngineA implements Engine {
    public EngineA(){    
        System.out.println("制造-->EngineA");    
    }    
}

class EngineB implements Engine {
    public EngineB(){
        System.out.println("制造-->EngineB");
    }
}