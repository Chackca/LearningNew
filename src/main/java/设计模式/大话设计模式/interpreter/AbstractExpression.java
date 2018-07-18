package 设计模式.大话设计模式.interpreter;

/**
 * 声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享
 * 
 * @author Chackca
 *
 */
public abstract class AbstractExpression {

    public abstract void interpret(Context context);
}
