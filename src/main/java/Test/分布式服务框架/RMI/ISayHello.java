package Test.分布式服务框架.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISayHello extends Remote{

    public String sayHello(String name) throws RemoteException;
}
