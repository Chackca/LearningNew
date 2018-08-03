package Test.分布式服务框架.RMI.demo;

import java.io.IOException;

public class UserClient {

    public static void main(String[] args) throws IOException {
        User user=new User_Stub();

        int age=user.getAge();//调用实现类stub的getAge方法

        System.out.println(age);
    }
}
