package 算法类.排序算法;

import java.util.Arrays;

public class 归并排序 implements Sort {

    @Override
    public void executeSort(int[] data) {
        Merge(data);
    }

    /*
	 * 归并排序
	 * 测试代码
	 *  int[] data = {9,8,7,6,5,4,3,2,1};
        sortUtils.Merge(data);
        System.out.println(Arrays.toString(data));
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


    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1};
        Merge(data);
        System.out.println(Arrays.toString(data));
    }



    //另外一种写法，与前一种的区别在于：前一种在递归之前就开辟了空间，这个需要频繁开辟
    public static int[] mergeSort(int[] data){
        if(data==null || data.length<=1)
            return data;
        mergeSortCore(data,0,data.length-1);
        return data;
    }
    //对data[start~mid]，data[mid+1~end]归并
    //典型的分治结构：结束条件+分治+和
    public static void mergeSortCore(int[] data,int start,int end){
        if(start>=end)
            return;
        int mid = start + (end - start)/2;
        mergeSortCore(data,start,mid);
        mergeSortCore(data,mid+1,end);
        mergeSortMerge(data,start,mid,end);
    }
    public static void mergeSortMerge(int[] data,int start,int mid,int end){
        if(end==start)
            return;
        int[] temp = new int[end-start+1];
        int left = start,right = mid+1,tempIndex = 0;
        while(left<=mid && right<=end){
            if(data[left]<data[right])
                temp[tempIndex++] = data[left++];
            else
                temp[tempIndex++] = data[right++];
        }
        while(left<=mid)
            temp[tempIndex++] = data[left++];
        while(right<=end)
            temp[tempIndex++] = data[right++];
        for(int i=0;i<temp.length;i++)
            data[start+i] = temp[i];
    }
}
