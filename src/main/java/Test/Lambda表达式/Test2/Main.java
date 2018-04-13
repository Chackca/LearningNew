package Test.Lambda表达式.Test2;

public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
            }
        }).start();


        new Thread(()-> System.out.println("lombda")).start();

    }
}
