package 算法类.其他题目;

import java.util.Scanner;

/**
 * 题目：
 在十进制表示中，任意一个正整数都可以用字符‘0’-‘9’表示出来。但是当‘0’-‘9’这些字符每种字符的数量有限时，
 可能有些正整数就无法表示出来了。比如你有两个‘1’，一个‘2’ ，那么你能表示出 11，12，121 等等，但是无法表示出 10，122，200 等数。

 现在你手上拥有一些字符，它们都是‘0’-‘9’的字符。你可以选出其中一些字符然后将它们组合成一个数字，那么你所无法组成的最小的正整数是多少？

 输入描述：
 第一行包含一个由字符’0’-‘9’组成的字符串，表示你可以使用的字符。1 ≤ 字符串长度 ≤ 1000

 输出描述：
 输出你所无法组成的最小正整数。

 样例1：
 55

 1

 样例2：
 123456789
 */
public class 扩展4数字字符再做 {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String s; //输入字符串
        while (sin.hasNext()) {
            s = sin.nextLine();
            int[] arr = new int[10]; //统计每个数字出现的频率
            int min = Integer.MAX_VALUE;//记录数量最少的数的数量
            int digit = -1;//记录数量最少的那个数
            if (s.length() > 0 && s.length() < 1001) {
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    ++arr[chs[i] - '0'];
                }

                for (int i = 1; i < arr.length; i++) {
                    //寻找最小值
                    if (min > arr[i]) {
                        min = arr[i];
                        digit = i;
                    }
                }
                //然后检查是否能够凑出n位数(1......n)
                //System.out.println(min);
                //最小的数是以0结尾的
                //如果0元素的数量<最小的那个数的数量
                if (arr[0] + 1 <= min) {
                    String str = "1";
                    for (int i = 0; i < min; i++) {
                        str += "0";
                    }
                    System.out.println(str);
                } else {
                    String str = digit + "";
                    for (int i = 0; i < min; i++) {
                        str += digit + "";
                    }
                    System.out.println(str);
                }
            }
        }
    }
}
