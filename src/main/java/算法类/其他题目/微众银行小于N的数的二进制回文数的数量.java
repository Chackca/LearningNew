package 算法类.其他题目;

import java.util.Scanner;

/**

 */
public class 微众银行小于N的数的二进制回文数的数量 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long N = sc.nextLong();
            long result = 0;
            for (long i = 0 ; i <= N ; i++){
                String number = Long.toBinaryString(i);
                if (isHuiWen(number)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean isHuiWen(String number){
        //String numberStr = String.valueOf(number);
        return number.equals(new StringBuffer(number).reverse().toString());
    }

    /*public static void main(String[] args) {
        for (long i = 1 ; i < 400 ; i++){
            String number = Long.toBinaryString(i);
            if (isHuiWen(number)){
                System.out.print(i+"  ");
                System.out.println(Integer.toBinaryString(i));
            }

        }
    }*/

}
