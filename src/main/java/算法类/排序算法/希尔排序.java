package 算法类.排序算法;

import org.junit.Test;

public class 希尔排序 implements Sort {

    @Override
    public void executeSort(int[] data) {
        shellSort(data);
    }

    /**
     * 希尔排序是插入排序的升级版
     * 希尔排序  http://www.cnblogs.com/skywang12345/p/3597597.html
     */
    //数组希尔排序(插入排序缩小增量)，时间o(n^1.3)，空间o(1)，不稳定
    //时间复杂度是模糊的，有人在大量的实验后得出结论：当n在某个特定的范围后希尔排序的比较和移动次数减少至n^1.3。次数取值在1到2之间。
    public static void shellSort(int[] data){
        if(data==null || data.length<=1)
            return;
        //第一趟表示，数据分为gap组，每组2个元素
        //第二趟表示，数据分为gap/2组，每组4个元素
        //...
        //直到gap=1，只有一组，组内元素都完成了排序
        for(int gap=data.length/2; gap>0; gap=gap/2){ //gap为步长，每次减为原来的一半
            //每次遍历从第二组的第一个元素开始，依次对后面的元素进行插入排序
            for(int i=gap;i<data.length;i++){
                int cur = i;
                int curValue = data[i];
                //这个步骤类似于直接插入排序
                while (cur-gap>=0 && data[cur-gap]>curValue) {
                    data[cur] = data[cur-gap];
                    cur = cur-gap;
                }
                data[cur]=curValue;
            }
        }
    }
    @Test
    public void testShellSort(){
        int[] data = {5,4,3,1,2,6,10,7,2,2,2,2,8,9,45};
        shellSort22(data);
        System.out.print("数组希尔排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }


    public static void shellSort22(int[] data){
        if(data==null || data.length<=1)
            return;
        for (int gap = data.length/2; gap>0; gap/=2) {
            for (int i = gap; i < data.length; i++) {
                int cur = i;
                int curValue = data[i];
                while (cur-gap>=0&&data[cur-gap]>curValue){
                    data[cur] = data[cur-gap];
                    cur = cur-gap;
                }
                data[cur] = curValue;
            }
        }
    }

}
