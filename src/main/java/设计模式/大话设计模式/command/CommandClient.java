package 设计模式.大话设计模式.command;

/**
 * 创建一个具体命令对象并设定它的接收者
 * 
 * @author liu yuning
 *
 */
//创建一个具体命令对象并设定它的接收者
public class CommandClient {
    public static void main(String[] args) {


		Reciever recieverA = new RecieverA();
		Reciever recieverB = new RecieverB();
		Reciever recieverC = new RecieverC();

		Command commandA = new ConcreteCommand(recieverA);
		Command commandB = new ConcreteCommand(recieverB);
		Command commandC = new ConcreteCommand(recieverC);

		Invoker invoker = new Invoker();
		invoker.addCommand(commandA);
		invoker.addCommand(commandB);
		invoker.addCommand(commandC);
		invoker.executeCommand();


		/*List<Reciever> recievers = new ArrayList<Reciever>();

		recievers.add(new RecieverA());
		recievers.add(new RecieverB());
		recievers.add(new RecieverC());
		Command command = new ConcreteCommand(recievers);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.executeCommand();*/
    }
}
