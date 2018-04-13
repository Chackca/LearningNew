package 设计模式.大话设计模式.command;

/**
 * 用来声明执行操作的接口
 * 
 * @author liu yuning
 *
 */
//用来声明执行操作的接口
public abstract class Command {
    //命令类，服务员手里的订单，订单里面包含了客户想要什么厨师做的菜
    protected Reciever reciever;
    public Command(Reciever reciever) {
	    this.reciever = reciever;
    }
    public abstract void execute();
}

// 将一个接收者对象绑定于一个动作，调用接收者相应的操作，以实现execute
class ConcreteCommand extends Command {
    public ConcreteCommand(Reciever reciever) {
	    super(reciever);
    }
    @Override
    public void execute() {
        reciever.action();
    }
}
