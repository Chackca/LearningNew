package 算法类.进制转换;

import java.util.Scanner;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class API进制转换 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //方式一：给定一个十进制数M，以及需要转换的进制N。将十进制数M转化为N进制数
        /*while (sc.hasNext()){
            String m=sc.next();  //十进制数
            int n=sc.nextInt();  //目标进制
            BigInteger bi=new BigInteger(m,10);  //转换为10进制的大数
            System.out.println(bi.toString(n).toUpperCase());  //转换为目标进制数
        }*/

        //方式二：给定一个n进制数，用字符串接受，将其转换为10进制数
        while (sc.hasNext()){
            String m=sc.nextLine();  //原来的数
            int n=Integer.parseInt(sc.nextLine());      //原来的数是几进制的
            int result = Integer.parseInt(m, n);
            System.out.println(result);  //输出转换为10进制数后的数
        }
    }
}
