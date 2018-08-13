package 算法类.其他题目;

import java.util.Scanner;

/**
 * 通过率30%
 */
public class 网易8月11日丰收 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();//n个苹果
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] query = new int[m];
            for (int i = 0; i < m; i++) {
                query[i] = in.nextInt();
            }

            //o(n)
            //记录每个篮子装的苹果开始的位置
            int[] bucket = new int[n+1];
            for (int i = 1; i <= n; i++) {
                bucket[i] = bucket[i-1];
                bucket[i] += arr[i-1];
            }

            //遍历询问的次数
            for (int i = 0; i < m; i++) {
                int target = query[i];
                int left = 0;
                int right = n-1;
                int middle ;
                while (left<right){
                    middle = left+(right-left)/2+(right-left)%2;
                    if (target>bucket[middle] && target>bucket[middle+1]){
                        left = middle;
                    }else if (target<bucket[middle]){
                        right = middle;
                    }else if(target>bucket[middle] && target<=bucket[middle+1]){
                        System.out.println(middle+1);
                        break;
                    }
                }


                /*for (int j = 0; j < n; j++) {
                    if (target>bucket[j] && target<=bucket[j+1]){
                        System.out.println(j+1);
                    }
                }*/
            }

            /**
5
2 7 3 4 9
3
1 25 11

5
2 7 3 4 9
2
25 11
             */
        }
    }
}
