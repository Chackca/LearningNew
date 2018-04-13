package 算法类.其他题目;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class aa {

    //这种做法在牛客网超时
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int between = sc.nextInt();
        if (n<1||between<0){
            System.out.println(-1);
        }
        int[] data = new int[n];
        for(int i = 0; i < n; i++){
            data[i] = sc.nextInt();
        }
        int result = 0;
        Set<Integer> set = new HashSet();
        for (int i = 0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (Math.abs(data[i]-data[j])==between){
                    if ( set.add(data[i]) | set.add(data[j]) ){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);

    }




    /**
     *
     */
    //双指针解法，这种更加快速
    public static int fun2 (int[] a) {
        a = new int[] {1,1,2,2,2,2,2,3,3,3,3,4};
        int between = 1;
        Set<Integer> set = new HashSet<>();
        //将不同的数据加入到set集合
        for (int i : a) {
            set.add(i);
        }
        //将数据重新组装为数组
        Integer[] aa = set.toArray(new Integer[1]);
        int n = aa.length;//记录不重复的数据个数
        int r = 0;
        int result = 0;
        for (int l = 0; l < n; l++) {
            //递增r指针，直到指向一个差值不小于k的值
            while (r < n && aa[r] - aa[l] < between) {
                r++; //
            }
            if (r >= n) {
                break;
            }
            if (aa[r] - aa[l] == between) {
                result++;
            }
            
        }
        return result;
    }
}
