package 设计模式.大话设计模式.factory.abstraction2;

//为宝马320系列生产配件
public class FactoryBMW320 implements AbstractFactory{
    @Override    
    public Engine createEngine() {
        return new EngineA();
    }    
    @Override    
    public Aircondition createAircondition() {
        return new AirconditionA();
    }    
}

//宝马523系列
class FactoryBMW523 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineB();
    }
    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}