package 设计模式.大话设计模式.command;

/**
 * 知道如何实施与执行一个与请求相关的操作，任何类都可能作为一个接收者。真正执行请求的地方！
 * 
 * @author liu yuning
 *
 */
//知道如何实施与执行一个与请求相关的操作，任何类都可能作为一个接收者。真正执行请求的地方！
interface Reciever {   //比喻为厨师
    public void action();
}

class RecieverA implements Reciever { //烤肉的厨师
    @Override
    public void action() {
	System.out.println("RecieverA执行请求！");
    }
}

class RecieverB implements Reciever { //炒菜的厨师
    @Override
    public void action() {
	System.out.println("RecieverB执行请求！");
    }
}

class RecieverC implements Reciever {  //烤鱼的厨师
    @Override
    public void action() {
	System.out.println("RecieverC执行请求！");
    }
}
