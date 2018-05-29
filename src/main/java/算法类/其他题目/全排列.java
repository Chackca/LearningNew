package 算法类.其他题目;

import java.util.Arrays;
import java.util.Scanner;

public class 全排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0 ; i < length ; i++){
                arr[i] = sc.nextInt();
            }
            for (int i = 0 ; i < length ; i++){
                System.out.print(arr[i]);
            }
            System.out.println();

            int times = length;
            while (length-1>0){
                times *= (length-1);
                length--;
            }
            for (int i= 0; i<times-1;i++){
                arr = findNearestNumber(arr);
                outputNumbers(arr);
            }
        }
    }

    //主流程，返回最近一个大于自身的相同数字组成的整数。
    public static int[] findNearestNumber(int[] numbers){
        //拷贝入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbersCopy);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回自身
        if (index == 0){
            return null;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers){
        for (int i=numbers.length- 1; i> 0; i--){
            if (numbers[i] > numbers[i- 1]){
                return i;
            }
        }
        return 0;
    }


    private static int[] exchangeHead(int[] numbers, int index){
        int head = numbers[index- 1];
        for (int i=numbers.length- 1; i> 0; i--){
            if (head < numbers[i]){
                numbers[index- 1] =  numbers[i];numbers[i] = head;
                break;
            }
        }
        return numbers;
    }
    private static int[] reverse(int[] num, int index){
        for (int i=index,j=num.length- 1; i<j; i++,j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static void outputNumbers(int[] numbers){
        for (int i : numbers){
            System.out.print(i);
        }
        System.out.println();
    }
}
