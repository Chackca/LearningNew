package 算法类.其他题目;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 通过率40%  超时
 */
public class 网易8月11小易的字典 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt(); //a
            int m = in.nextInt();//z
            int k = in.nextInt();//第k个单词

            int[] arr = new int[n + m];
            for (int i = 0; i < n; i++) {
                arr[i] = 1;
            }
            for (int i = 0; i < m; i++) {
                arr[n + i] = 2;
            }
            for (int i = 0; i < k-1; i++) {
                arr = findNearestNumber(arr);
            }

            outputNumbers(arr);
        }
    }

    //输出数组
    private static void outputNumbers(int[] numbers){
        for(int i : numbers){
            if (i==1)
                System.out.print("a");
            else
                System.out.print("z");
        }
        System.out.println();
    }

    public static int[] findNearestNumber(int[] numbers){
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        int index = findTransferPoint(numbersCopy);
        if(index == 0){
            return null;
        }
        exchangeHead(numbersCopy, index);
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers){
        for(int i=numbers.length-1; i>0; i--){
            if(numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }

    private  static int[] exchangeHead(int[] numbers, int index){
        int head = numbers[index-1];
        for(int i=numbers.length-1; i>0; i--){
            if(head < numbers[i]){
                numbers[index-1] =  numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int index){
        for(int i=index,j=num.length-1; i<j; i++,j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

}
