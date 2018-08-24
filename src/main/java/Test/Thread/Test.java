package Test.Thread;

/**
 * @Author Chackca
 * @Description :实现按顺序打印线程
 * @Date 2018/8/20 15:18
 **/
public class Test {
    static Thread aa;
    static Thread bb;
    static Thread cc;
    public static void main(String[] args) {
        AAA a = new AAA("A");
        AAA b = new AAA("B");
        AAA c = new AAA("C");
        aa = new Thread(a);
        bb = new Thread(b);
        cc = new Thread(c);
        aa.start();
        bb.start();
        cc.start();
    }

    public static class AAA implements Runnable{
        private String str = null;

        public AAA(String str){
            this.str = str;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    switch (str){
                        case "A": break;
                        case "B": aa.join(); break;
                        case "C": bb.join(); break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"::::"+str);
            }
        }
    }

}
