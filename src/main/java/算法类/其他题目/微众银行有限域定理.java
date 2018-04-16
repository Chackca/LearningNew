package 算法类.其他题目;

import java.util.ArrayList;
import java.util.Scanner;

/*
题目描述：
在抽象代数中，我们学过一个关于有限域的定理：存在一个大小为q的有限域当且仅当q是某个素数p的方幂，即q=pk ,𝑘 ≥ 1，且在同构意义下，相同大小的有限域只有一个。 作为新时代的数学工作者，你决定运用这个定理写一个程序来计算同构意义下的不同有限域个数。对于一个给定的输入𝑛，你需要计算有多少个不同构的有限域，它们的大小是不超过n的。

输入
第一行包含一个整数𝑛。1 ≤ 𝑛 ≤ 1000

输出
输出阶数不超过𝑛的有限域的个数。


样例输入
1

样例输出
0


Hint
Input Sample 2
37
Output Sample 2
19
如第二组样例，当 n 为 37 时，在 1-37 范围内，以下 19 个整数可以表示成某个素数的方
幂：2，3，4，5，7，8，9，11，13，16，17，19，23，25，27，29，31，32，37。
 */
public class 微众银行有限域定理 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=1;
        int n=in.nextInt();
        ArrayList<Integer> rt=new ArrayList<>();
        for(int x=2;x<=n;x++) {
            for(int i=2;i<x;i++){
                a=1;
                if(x%i==0) {
                    a=0;
                    break;
                }
            }
            if(a==1){
               rt.add(x);
            }
        }
        int sum=rt.size();
        for(int i=0;i<sum;i++) {
            for(int k=2;Math.pow(rt.get(i),k)<n;k++) {
                rt.add((int)Math.pow(rt.get(i),k));
            }
        }
        for(int i=0;i<rt.size();i++) {
                System.out.println(rt.get(i));
            }
        System.out.println(rt.size());
    }
    

   /*public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int result = 0;
            for (int i = 2;i <= N ; i++){
                if (isPrime(i)){
                    result ++;
                    //System.out.println(i);
                }else {
                    //boolean happen = false;
                    for (int j = 2; j <= i/2; j++) {
                        double temp = Math.pow(i,1.0/j);
                        int intt = (int)temp;
                        if (intt<=1){
                            break;
                        }
                        else if ( intt == temp && isPrime(intt)){
                            if (happen){
                                result--;
                                break;
                            }
                            if (isPrime(intt)) {
                                //happen = true;
                                result++;
                            }
                            //System.out.println(i);
                        }
                    }
                }
            }

            System.out.println(result);

        }
    }

    public static boolean isPrime(int number){
        if (number<2) return false;
        boolean result = true;
        for (int i = 2;i<=Math.sqrt(number);i++){
            if (number%i==0){
                result = false;
                break;
            }
        }
        return result;
    }*/
}
