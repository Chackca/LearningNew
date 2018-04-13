package 设计模式.大话设计模式.factory.method;

import 设计模式.大话设计模式.factory.simple.Operation;

/**
 * 工厂方法客户端
 * 
 * @author liu yuning
 *
 */
public class FactoryClient {
    public static void main(String[] args) {
    Operation operation;
	IFactory operFactory = new DivFactory();
	operation = operFactory.createOperation();
	operation.numberA = 3.4;
	operation.numberB = 4.5;
	System.out.println(operation.result());
    }
}