package 设计模式.大话设计模式.factory.method;

import 设计模式.大话设计模式.factory.simple.*;

/**
 * 工厂接口
 * 
 * @author liu yuning
 *
 */
public interface IFactory {
    public Operation createOperation();
}

class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
	return new OperationAdd();
    }
}

class SubFactory implements IFactory {
    @Override
    public Operation createOperation() {
	return new OperationSub();
    }
}

class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationMul();
    }

}

class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationDiv();
    }

}