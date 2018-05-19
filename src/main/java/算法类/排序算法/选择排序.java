package 算法类.排序算法;

import org.junit.*;
public class 选择排序 implements Sort {
    @Override
    public void executeSort(int[] data) {
        selectionSort(data);
    }
    /*
     * 选择排序
     */
    public static void selectionSort(int[] data){
        if(data == null) return;
        int curMinIndex = 0;
        for (int i = 0; i < data.length-1; i++) {
            curMinIndex=i;
            for (int j = i; j < data.length; j++) {
                if (data[curMinIndex]>data[j]) {
                    curMinIndex = j;
                }
            }
            int temp = data[i];
            data[i]=data[curMinIndex];
            data[curMinIndex]=temp;
        }
    }

    @Test
    public void testSelectionSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        selectionSort(data);
        System.out.print("数组选择排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
