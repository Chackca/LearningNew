package 算法类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SortTestUtil {
    /**
     * 用于交换数组中的两个元素
     * @param data
     * @param index
     * @param index2
     */
    public static void swap(int[] data, int index, int index2) {
        int temp = data[index2];
        data[index2] = data[index];
        data[index] = temp;
    }

    /**
     * 生成包含重复元素的有n个元素的随机数组，每个元素的随机范围为[rangL,rangeR]
     * @param n
     * @param min
     * @param max
     * @return
     */
    public static int[] generateRandomArray(int n, int min, int max) {
        if (max < min)
            System.err.println("SortTestUtil：generateRandomArray您的输入参数有错");
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0 ; i < n ; i++)
            arr[i] = random.nextInt(max)%(max-min+1) + min;
        if (n<50)
            System.out.println("原始生成未排序的数组为"+Arrays.toString(arr));
        return arr;
    }

    /**
     * 生成包含重复元素的有n个元素的随机排序的数组，每个元素的随机范围为[rangL,rangeR]
     * @param n
     * @param min
     * @param max
     * @return
     */
    public static int[] generateRandomSortArray(int n, int min, int max) {
        int[] arr = generateRandomSortArray(n,min,max);
        Arrays.sort(arr);
        if (n<50)
            System.out.println("原始生成排序后的数组为"+Arrays.toString(arr));
        return arr;
    }

    /**
     *  生成不包含重复素的有n个元素的随机排序的数组，每个元素的随机范围为[rangL,rangeR]
     * @param n
     * @param min
     * @param max
     */
    public static int[] generateRandomArrayWithoutRepeatNumber(int n, int min, int max) {
        if (n > (max - min + 1) || max < min)
            System.err.println("SortTestUtil：generateRandomArrayWithoutRepeatNumber您的输入参数有错");
        HashSet set = new HashSet();
        int[] arr = new int[n];
        int length = 0;
        while (set.size()<n){
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            if (set.add(num)){
                arr[length]=num;
                length++;
            }
        }
        if (n<50)
            System.out.println("原始生成未排序的数组为"+Arrays.toString(arr));
        return arr;
    }

    /**
     *  生成不包含重复素的有n个元素的排序随机排序的数组，每个元素的随机范围为[rangL,rangeR]
     * @param n
     * @param min
     * @param max
     */
    public static int[] generateRandomSortArrayWithoutRepeatNumber(int n, int min, int max) {
        int[] arr = generateRandomArrayWithoutRepeatNumber(n,min,max);
        Arrays.sort(arr);
        if (n<50)
            System.out.println("原始生成排序后的数组为"+Arrays.toString(arr));
        return arr;
    }

}
