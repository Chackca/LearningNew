package Test.分布式服务框架.RMI.demo;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class User_Stub extends User{

    private Socket socket;

    public User_Stub() throws IOException {
        socket=new Socket("localhost",8888);
    }

    public int getAge() throws IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject("age");
        outputStream.flush();

        ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
        int age=objectInputStream.readInt();
        return age;
    }
}
