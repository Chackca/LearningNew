package 设计模式.模式.观察者模式;
public class Test  
{  
     public static void main(String[] args)  
     {  
          Transporter transporter = new Transporter();  
          Police police = new Police();  
          Security security = new Security();  
          Thief thief = new Thief();  
          transporter.addWatcher(police);  
          transporter.addWatcher(security);  
          transporter.addWatcher(security);  
          transporter.notifyWatchers();  
     }  
}  