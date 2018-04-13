package 设计模式.模式.观察者模式;

//抽象的被观察者，在其中声明方法（添加、移除观察者，通知观察者）：
public interface Watched  
{  
     public void addWatcher(Watcher watcher);  

     public void removeWatcher(Watcher watcher);  

     public void notifyWatchers();  
}  