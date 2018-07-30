package 算法类.排序算法;

import org.junit.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//https://mp.weixin.qq.com/s/wO11PDZSM5pQ0DfbQjKRQA
public class 冒泡排序 implements Sort {
    @Override
    public void executeSort(int[] data) {
        bubbleSortUpdate(data);
    }

    /*
     * 普通的冒泡排序
     */
    public static void bubbleSort(int[] data){
        if(data == null) return;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length-i; j++) {
                if (data[j-1]>data[j]) {
                    int temp = data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                }
            }
        }
        return;
    }

    /*
     * 优化版的冒泡排序
     */
    public static void bubbleSortUpdate(int[] data){
        if(data == null) return;
        //记录最后一次交换的位置
        int lastExchangeIndex =0; //解决原数组中后部分都为有序情况下的比较浪费
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = data.length;
        for (int i = 0; i < data.length; i++) {
            //有序标记，每一轮的初始是true，当有一轮比较没有找到需要更换位置的数据时，可以直接退出整个循环了
            boolean isSorted = true;
            for (int j = 1; j < sortBorder; j++) {
                if (data[j-1]>data[j]) {
                    int temp = data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex  = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted)
                break;
        }
        return;
    }




    @Test
    public void testBubbleSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        bubbleSortUpdate(data);
        System.out.print("数组冒泡排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
