package Test.序列化.Externalizable;

import java.io.*;

public class ExternalizableDemo1 {

  public static void main(String[] args) {
      //Write Obj to file
      User1 user = new User1();
      user.setName("chackca");
      user.setAge(22);
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))){
          oos.writeObject(user);
      } catch (IOException e) {
          e.printStackTrace();
      }

      //Read Obj from file
      File file = new File("tempFile");
      try(ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file))){
          User1 newInstance = (User1) ois.readObject();
          //output
          System.out.println(newInstance);

      } catch (IOException | ClassNotFoundException e ) {
          e.printStackTrace();
      }
  }
}