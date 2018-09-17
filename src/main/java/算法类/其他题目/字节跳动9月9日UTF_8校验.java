package 算法类.其他题目;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class 字节跳动9月9日UTF_8校验 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Integer.toBinaryString(arr[i]));
            }
        }
    }

    public static boolean isUTF8(String key){
        try {
            key.getBytes("utf-8");
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

}
