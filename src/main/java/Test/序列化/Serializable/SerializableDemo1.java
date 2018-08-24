package Test.序列化.Serializable;

import java.io.*;

public class SerializableDemo1 {

   public static void main(String[] args) {
       //Initializes The Object
       User1 user = new User1();
       user.setName("chackca");
       user.setAge(22);
       System.out.println(user);

       //Write Obj to File
       try (FileOutputStream fos = new FileOutputStream("tempFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
           oos.writeObject(user);
       } catch (IOException e) {
           e.printStackTrace();
       }

       //Read Obj from File
       File file = new File("tempFile");
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
           User1 newUser = (User1)ois.readObject();
           System.out.println(newUser);

       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
   }
}