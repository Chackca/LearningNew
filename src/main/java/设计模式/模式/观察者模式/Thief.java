package 设计模式.模式.观察者模式;

//具体的观察者
//小偷
public class Thief implements Watcher  
{  
     @Override  
     public void update()  
     {  
          System.out.println("运输车有行动，强盗准备动手");  
     }  
}  