package 单例模式;

public class Singleton1 {

    private static volatile Singleton1 singleton1 = null;

    private Singleton1(){}

    public Singleton1 getInstance(){
        if (singleton1 == null){
            synchronized (singleton1){
                if (singleton1==null){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
