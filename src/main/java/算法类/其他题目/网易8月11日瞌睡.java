package 算法类.其他题目;

import java.util.Scanner;

/**
 * 通过率80%
 */
public class 网易8月11日瞌睡 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            int[] trr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                trr[i] = in.nextInt();
            }
            long mustGet = 0;
            int numOfZero = 0;
            for (int i = 0; i < n ; i ++) {
                if (trr[i]==1)
                    mustGet += arr[i];
                else numOfZero++;
            }
            long temp[] = new long[numOfZero];
            int tempIndex = 0;
            for (int i = 0; i < n ; i ++) {
                if (trr[i]==0){
                    temp[tempIndex] = mustGet;
                    for (int j = i;j<(i+k) && (i+k)<n ;j++){
                        if (trr[j]==0){
                            temp[tempIndex] += arr[j];
                        }
                    }
                    tempIndex++;
                }
            }
            long res = 0;
            for (int i = 0; i < numOfZero ; i ++) {
                if (temp[i] > res)
                    res = temp[i];
            }
            System.out.println(res);
        }
    }
}
