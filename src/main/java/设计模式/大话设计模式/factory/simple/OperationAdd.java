package 设计模式.大话设计模式.factory.simple;

/**
 * 加法类
 * 
 * @author liu yuning
 *
 */
public class OperationAdd extends Operation {
    @Override
    public double result() {
	return numberA + numberB;
    }
}