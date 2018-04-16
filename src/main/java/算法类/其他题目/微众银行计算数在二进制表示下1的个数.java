package 算法类.其他题目;

import java.util.Scanner;
/**

 */
public class 微众银行计算数在二进制表示下1的个数 {

    //注意可以通过测试数据的输出找出规律
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            System.out.println("答案是:"+(b-c+1));//+1代表2的a次方提供的最高位的1

            /*System.out.println(a+"的二进制表示"+Long.toBinaryString(a));
            System.out.println(b+"的二进制表示"+Long.toBinaryString(b));
            System.out.println(c+"的二进制表示"+Long.toBinaryString(c));*/

            //long value = new Double(Math.pow(2,a)+Math.pow(2,b)-Math.pow(2,c)).longValue();
            System.out.println();
            System.out.println("下面为测试的数据");
            System.out.println("2的"+a+"次方的二进制表示"+Long.toBinaryString((long)Math.pow(2,a)));
            System.out.println("2的"+b+"次方的二进制表示="+Long.toBinaryString((long)Math.pow(2,b)));
            System.out.println("2的"+c+"次方的二进制表示="+Long.toBinaryString((long)Math.pow(2,c)));

            //System.out.println("结果的二进制表示"+Long.toBinaryString(value));

            //System.out.println(numberOf1(value));
        }
    }

    public static long numberOf1(long n) {
        long count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
