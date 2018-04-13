package 设计模式.大话设计模式.factory.simple;

/**
 * 乘法类
 * 
 * @author liu yuning
 *
 */
public class OperationMul extends Operation {

    @Override
    public double result() {
	return numberA * numberB;
    }

}