package 算法类.其他题目;

import java.util.Scanner;

public class 今日头条求函数调用次数未理解 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        String s = new String("a");
        String m = s;

        String target = "";
        while (target.length() < n) {

        }

    }

    public static String method1(String s, String m) {
        m = s;
        return (s + s);
    }

    public static String method2(String s, String m) {
        return (s + m);
    }*/


    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int n = cs.nextInt();
        int r = 0;
        for (int i = 0; n >= 1; i++) {
            if (n % 2 == 1) {
                r = n - 1 + i;
                System.out.print(r);
                break;
            } else {
                n = n / 2;
            }
        }
    }
}
