package 算法类.其他题目;

/**
 /**
 * 顺丰1018.3.30后台笔试题
 * 幸运数
 *
 * 4和7是两个幸运数字，我们定义，十进制表示中，每一位只有4和7两个数的正整数都是幸运数字。
   前几个幸运数字为：4,7,44,47,74,77,444,447...
   现在输入一个数字K，输出不大于这个数的幸运数的个数
 */

import java.util.Scanner;

public class 顺丰幸运数 {

    //输入一个值，返回不大于这个值的幸运数的个数
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            long target=Integer.parseInt(sc.nextLine());
            long result = 0l;
            //long index = 0;
            for (long i = 1l ;LuckyNumber(i+1)<=target;i++){
                result = i;
            }
            //System.out.println(result);
        }
    }

    //返回第n-1个幸运数
    public static long LuckyNumber(long n){
        String value = Long.toBinaryString(n);
        StringBuilder SB = new StringBuilder();
        //0->4;1->7;舍弃最高位
        for(int i=1 ; i < value.length() ; i++){
            if(value.charAt(i) == '0') {
                SB.append("4");
            }
            else{
                SB.append("7");
            }
        }
        System.out.print("第"+(n-1)+"个幸运数是："+SB.toString());
        System.out.println();
        return Long.parseLong(SB.toString());
    }
}