package 设计模式.模式.观察者模式;

//具体的观察者
//警察
public class Police implements Watcher
{  
     @Override  
     public void update()  
     {  
          System.out.println("运输车有行动，警察护航");
     }  
}  