package 算法类.排序算法;

import org.junit.Test;

import java.util.Arrays;

public class 归并排序 implements Sort {

    @Override
    public void executeSort(int[] data) {
        Merge(data);
    }

    /*
	 * 归并排序
	 */
    public static void Merge(int[] data){
        if (data==null) return;
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[data.length];
        sort(data,0,data.length-1,temp);
    }
    private static void sort(int[] data, int start, int end, int[] temp) {
        if(start<end){
            int mid = start + (end - start)/2;
            sort(data,start,mid,temp);//左边归并排序，使得左子序列有序
            sort(data,mid+1,end,temp);//右边归并排序，使得右子序列有序
            merge(data,start,mid,end,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] data, int start, int mid, int end, int[] temp) {
        int left = start;//左序列指针
        int right = mid+1;//右序列指针
        int tempIndex = 0;//临时数组指针
        while (left<=mid && right<=end){
            if(data[left]<=data[right]){
                temp[tempIndex++] = data[left++];
            }else {
                temp[tempIndex++] = data[right++];
            }
        }
        while(left<=mid){//将左边剩余元素填充进temp中
            temp[tempIndex++] = data[left++];
        }
        while(right<=end){//将右序列剩余元素填充进temp中
            temp[tempIndex++] = data[right++];
        }
        tempIndex = 0;
        //将temp中的元素全部拷贝到原数组中
        while(start <= end){
            data[start++] = temp[tempIndex++];
        }
    }



    //自底向上的归并排序,未实现
    /*public static void MergeSortBU(int[] data){
        if (data==null) return;
        int length = data.length;
        for (int sz = 1; sz<=length; sz+=sz){
            for ( int i = 0 ; i + sz < length ; i+=sz+sz){
                //对data[i...i+sz-1]和data[i+sz...i+2*sz-1]进行合并
                merge(data,i,i+sz-1,Math.min((i+sz+sz-1),length-1);
            }
        }

    }

    private static void merge(int[] data, int i, int i1, int i2) {

    }*/


    @Test
    public void testMergerSort() {
        int[] data = {9,3,7,6,5,4,2,8,1};
        Merge(data);
        System.out.println(Arrays.toString(data));
    }





}
