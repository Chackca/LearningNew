package 算法类.其他题目;

import java.util.Arrays;

/**
 * 题目描述
 找出n个数里最小的k个
 输入描述:
 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
 不超过100。
 输出描述:
 输出n个整数里最小的k个数。升序输出
 示例1
 输入

 3 9 6 8 -10 7 -11 19 30 12 23 5
 输出

 -11 -10 3 6 7
 */
public class 牛客找出n个数里最小的k个 {

    private static void findSmallest(String str) {
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length-1];
        int k = Integer.parseInt(strings[strings.length-1]);

        for (int i = 0 ; i < strings.length-1 ; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i<k ;i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
        String str = new String("3 9 6 8 -10 7 -11 19 30 12 23 5");
        findSmallest(str);
    }


}
