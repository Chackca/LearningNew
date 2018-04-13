package 设计模式.大话设计模式.expression;

//声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享
public abstract class AbstractExpression {
    public abstract void interpret(Context context);
}

//实现与文法中的终结符相关联的解释操作，文法中每一个终结符都有一个具体终结表达式与之相对应
class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        //这里根据传入的输入对象进行翻译，
        context.setOutput("“这是英语”");
        System.out.println("终端解释器："+"原始信息："
                +context.getInput()+"将会被翻译为："+context.getOutput());
    }
}

class NonTerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        //这里根据传入的输入对象进行翻译，
        context.setOutput("“123456”");
        System.out.println("非终端解释器："+"原始信息："
                +context.getInput()+"将会被翻译为："+context.getOutput());
    }
}
