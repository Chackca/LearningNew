package Test.分布式服务框架.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHelloImpl extends UnicastRemoteObject implements ISayHello{

    public SayHelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello Mic->"+name;
    }
}
