package 算法类.排序算法;

import org.junit.*;
import 算法类.domain.SortTestUtil;

public class 插入排序 implements Sort {

    @Override
    public void executeSort(int[] data) {

    }
    /*
     * 直接插入排序
     */
    public static void insertionSort(int[] data){
        if(data == null) return;
        int curValue = 0;
        int index = 0;
        for (int i = 1; i < data.length; i++) {
            //因为需要对索引进行计算，但是不能动用i，所以生成一个index来作为计算用的索引
            index = i;//存储当前临时索引
            curValue = data[i];//存储当前值
            //做法一：
            while (index-1>=0&&data[index-1]>curValue) {
                data[index]=data[index-1];//将当前值的位置用其前一个元素替代
                index--;
            }
            data[index] = curValue;//将最终的位置赋值上当前值
            //做法二：
            /*while (index-1>=0&&data[index-1]>curValue) {
                SortTestUtil.swap(data, index, index-1);
                index--;
            }*/
        }
    }

    @Test
    public void testInsertionSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        insertionSort(data);
        System.out.print("数组插入排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
