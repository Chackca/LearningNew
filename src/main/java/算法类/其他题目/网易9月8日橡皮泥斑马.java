package 算法类.其他题目;

import java.util.Scanner;

public class 网易9月8日橡皮泥斑马 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] arr = line.toCharArray();
        int res = 0;
        for (int i = 1; i < line.length(); i++) {
            if (arr[i - 1] == arr[i]) {
                reverse(arr, 0, i - 1);
                reverse(arr, i, arr.length - 1);
            }
        }
        int sum = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                sum += 1; //                System.out.println(sum);
            } else {
                sum = 1;
            }
            if (res < sum) {
                res = sum;
            }
        }
        System.out.println(res);
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }


    /*private static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            int i = execute1(str, 1, str.charAt(0), str.charAt(str.length() - 1), 1);
            System.out.println(i);
        }
    }

    private static int execute1(String str,int index,char start,char end,int count) {
        char temp = str.charAt(index-1);
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) != temp){
                count++;
                temp = str.charAt(i);
                if (max<count)
                    max = count;
            }
            else {
                //代表前面进行了翻转
                if (start != str.charAt(i)){
                    start = str.charAt(i);
                    count++;
                    int res1 = execute1(str,i,start,end,count);
                    if (max<res1)
                        max = res1;
                }
                if (end != str.charAt(i)){
                    end = str.charAt(i);
                    count++;
                    int res2 = execute1(str,i,start,end,count);
                    if (max<res2)
                        max = res2;
                }
            }
        }
        return max;
    }*/

}
