package 算法类.排序算法;

import org.junit.Test;
import 算法类.domain.SortTestUtil;

public class 选择排序 implements Sort {
    @Override
    public void executeSort(int[] data) {
        selectionSort(data);
    }

    /**
     * 选择排序
     * 从0开始遍历第一遍，记录下最小的，遍历结束后将其放在数组0位置
     * 从1开始遍历第二遍，记录下最小的，遍历结束后将其放在数组1位置
     */
    public static void selectionSort(int[] data) {
        if (data == null) return;
        int curMinIndex = 0;
        for (int i = 0; i < data.length - 1; i++) {
            curMinIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[curMinIndex] > data[j]) {
                    curMinIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[curMinIndex];
            data[curMinIndex] = temp;
        }
    }

    @Test
    public void testSelectionSort() {
        int[] data = SortTestUtil.generateRandomArrayWithoutRepeat(10, 0, 20);
        selectionSort(data);

        System.out.print("数组选择排序：\t");
        for (int item : data) {
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

}