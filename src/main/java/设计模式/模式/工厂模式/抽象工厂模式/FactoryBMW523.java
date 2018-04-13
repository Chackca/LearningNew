package 设计模式.模式.工厂模式.抽象工厂模式;
//宝马523系列  
public class FactoryBMW523 implements AbstractFactory {    
    
     @Override    
    public Engine createEngine() {      
        return new EngineB();    
    }    
    @Override    
    public Aircondition createAircondition() {    
        return new AirconditionB();    
    }    
  
  
}   