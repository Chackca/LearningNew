package 算法类.排序算法;

import org.junit.Test;

public class 希尔排序 implements Sort {

    @Override
    public void executeSort(int[] data) {
        shellSort(data);
    }

    /*
     * 希尔排序
     */
    //数组希尔排序(插入排序缩小增量)，时间o(n^1.3)，空间o(1)，不稳定
    //时间复杂度是模糊的，有人在大量的实验后得出结论：当n在某个特定的范围后希尔排序的比较和移动次数减少至n^1.3。次数取值在1到2之间。
    public static void shellSort(int[] data){
        if(data==null || data.length<=1)
            return;
        //数组长12 d=6  d=3
        for(int gap=data.length/2; gap>0; gap=gap/2){
            //i=6 7   /  3 4 5
            for(int i=gap;i<data.length;i++){
                int cur = i;
                int temp = data[i];
                //这个步骤类似于直接插入排序
                while (cur-gap>=0 && data[cur-gap]>temp) {
                    data[cur] = data[cur-gap];
                    cur = cur-gap;
                }
                data[cur]=temp;
            }
        }
    }
    @Test
    private void testShellSort(){
        int[] data = {5,4,3,1,2,6,10,7,2,2,2,2,8,9,45};
        shellSort(data);
        System.out.print("数组希尔排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
