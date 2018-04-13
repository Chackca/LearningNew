package 设计模式.大话设计模式.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 要求该命令执行这个请求
 * 
 * @author liu yuning
 *
 */
//要求该命令执行这个请求
public class Invoker {//服务员，拥有很多订单
    private List<Command> list = new ArrayList();
    public void addCommand(Command command) {
        list.add(command);
    }
    public void executeCommand() {
        for (Command command:list) {
            command.execute();
        }
    }
}
