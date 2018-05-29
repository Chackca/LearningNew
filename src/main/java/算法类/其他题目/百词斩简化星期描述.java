package 算法类.其他题目;

import java.util.Scanner;

/**
 * 给定一组1到7组成的数字，有序不重复，若连续的数字达到3或3以上，则记录其第一个与最后一个，
 * 否则原样输出，
 * 比如输入第一个数字5，代表数组有5个元素，随后1 3 4 5 7，则输出1,3-5,7
 * 输入6，随后1 2 3 5 6 7，输出1-3,5-7
 */

public class 百词斩简化星期描述 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0 ; i < length ; i++){
                arr[i] = sc.nextInt();
            }
            StringBuilder SB = new StringBuilder();

            int count = 0;

            //int first = 0;
            int end = 0;

            if (length>1) { //代表数组至少两个元素
                //SB.append(arr[0]);
                boolean first = true;
                for (int i = 1; i < length ; i++){
                    if (arr[i]-arr[i-1]==1){
                        if (first){
                            first = false;
                            SB.append(arr[i-1]);
                            SB.append("-");
                        }
                        count++;
                        if (i == length-1){
                            if (count >= 2 ){
                                SB.append(arr[i]);
                            }else if (count == 1){
                                SB.deleteCharAt(SB.length()-1);
                                SB.append(",");
                               // SB.append(arr[i-1]);
                               // SB.append(",");
                                SB.append(arr[i]);
                            }
                        }
                    }else if (count >= 2 ){
                        SB.append(arr[i-1]);
                        SB.append(",");
                        if (i == length-1){
                            SB.append(arr[i]);
                        }
                        count = 0;
                    }else {
                        if (!first){
                            SB.deleteCharAt(SB.length()-1);
                            SB.append(",");
                        }
                        if (count==1){
                            SB.append(arr[i-1]);
                            SB.append(",");
                        }
                        if (count == 0){
                            SB.append(arr[i-1]);
                            SB.append(",");
                        }
                        first = true;
                        if (i == length-1){
                            SB.append(arr[i]);
                        }
                        count = 0;
                    }
                }
            }else {
                System.out.println(arr[0]);
            }



            /*if (length>1) { //代表数组至少两个元素
                boolean first = true;
                for (int i = 1; i < length; i++) {
                    if (arr[i] - arr[i-1] == 1){
                        if (first) {
                            SB.append(arr[i - 1]);
                            SB.append("-");
                            first = false;
                            count ++;
                        }else {
                            continue;
                        }
                    }else if (count >= 2){
                        SB.append(arr[i - 1]);
                        SB.append(",");
                        count = 0;
                        first = true;
                    }else {
                        SB.append(arr[i-1]);
                        SB.append(",");
                        SB.append(arr[i]);
                    }

                }
            }else {
                System.out.println(arr[0]);
            }*/

            System.out.println(SB.toString());

        }
    }
}
