package Test.序列化.Externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author Chackca
 * @Description : 注意实现Externalizable的类需要重写两个方法，并且要提供无参构造器
 * @Date 2018/8/19 11:07
 **/
public class User1 implements Externalizable {

   private String name;
   private int age;

   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public int getAge() {
       return age;
   }
   public void setAge(int age) {
       this.age = age;
   }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
   @Override
   public String toString() {
       return "User{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
   }
}