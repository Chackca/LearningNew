package 算法类.排序算法;

import 算法类.domain.SortTestUtil;

public class Test {

    /**
     * 优化版冒泡排序
     * @param arr
     * @return
     */
    public int[] sort7(int[] arr){

        System.out.println("冒泡排序");
        boolean hasChange = false;
        int border = arr.length-1;
        int lastChangeIndex = 0;

        for (int i = arr.length-1; i >=0 ; i--) {
            for (int j = 1; j <= border; j++) {
                if (arr[j]<arr[j-1]){
                    lastChangeIndex = j;
                    hasChange = true;
                    SortTestUtil.swap(arr,j-1,j);
                }
            }
            border = lastChangeIndex;
            if (!hasChange){
                break;
            }
        }

        return arr;
    }


    /**
     * 选择排序
     * @param arr
     * @return
     */
    public int[] sort(int[] arr){
        System.out.println("选择排序");
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    index = j;
                 }
            }
            SortTestUtil.swap(arr,i,index);
            //arr[i]=min;
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public int[] sort2(int[] arr){
        System.out.println("插入排序");
        for (int i = 1; i < arr.length; i++) {
            int curValue = arr[i];
            int curIndex = i;
            while (curIndex-1>=0 && arr[curIndex-1] > curValue){
                arr[curIndex] = arr[curIndex-1];
                curIndex--;
            }
            arr[curIndex] = curValue;
        }
        return arr;
    }


    /**
     * 希尔排序
     * @param arr
     * @return
     */
    public int[] sort3(int[] arr){
        System.out.println("希尔排序");
        for (int gap = arr.length/2; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length; i++) {
                int curIndex = i;
                int curValue = arr[i];
                while (curIndex - gap >= 0 && arr[curIndex - gap] > curValue ){
                    arr[curIndex] = arr[curIndex-gap];
                    curIndex -= gap;
                }
                arr[curIndex] = curValue;
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * @param arr
     * @return
     */
    public int[] sort4(int[] arr){
        System.out.println("快速排序");
        sort(arr,0,arr.length-1);
        return arr;
    }

    private void sort(int[] arr, int left, int right) {
        if (left>=right)
            return;
        int partition = partition(arr,left,right);
        sort(arr,left,partition-1);
        sort(arr,partition+1,right);
    }

    private int partition(int[] arr, int left, int right) {
        int target = arr[left];
        while (left<right){
            while (left<right && arr[right] > target){
                right--;
            }
            if (left<right && arr[right] <= target){
                SortTestUtil.swap(arr,left,right);
            }
            while (left<right && arr[left] < target){
                left++;
            }
            if (left<right && arr[left] >= target){
                SortTestUtil.swap(arr,left,right);
            }
        }
        return left;
    }



    /**
     * 归并排序
     * @param arr
     * @return
     */
    public int[] sort5(int[] arr){
        System.out.println("归并排序");
        int[] temp = new int[arr.length];
        merge(arr,0,arr.length-1,temp);
        return arr;
    }

    private void merge(int[] arr, int left, int right, int[] temp) {
        if (left>=right)
            return;
        int mid = left + (right - left)/2;
        merge(arr,left,mid,temp);
        merge(arr,mid+1,right,temp);
        mergeSort(arr,left,right,mid,temp);
    }

    private void mergeSort(int[] arr, int left, int right, int mid, int[] temp) {
        if (left>right)
            return;
        int start = left;
        int start2 = mid+1;
        int tempIndex = 0;
        while (start <= mid && start2 <=right){
            if (arr[start]<arr[start2]) {
                temp[tempIndex++] = arr[start++];
            } else {
                temp[tempIndex++] = arr[start2++];
            }
        }
        while (start <= mid) {
            temp[tempIndex++] = arr[start++];
        }
        while (start2 <=right)  {
            temp[tempIndex++] = arr[start2++];
        }

        tempIndex=0;
        for (int i = left; i <= right; i++) {
            arr[i] = temp[tempIndex++];
        }
    }


    /**
     * 堆排序
     * @param arr
     * @return
     */
    public int[] sort6(int[] arr) {
        System.out.println("堆排序");
        for (int i = arr.length/2-1; i >=0 ; i--) {
            heapSort(arr,i,arr.length -1);
        }
        for (int i = 0; i < arr.length; i++) {
            SortTestUtil.swap(arr,0,arr.length-i-1);
            heapSort(arr,0,arr.length -i-1);
        }
        return arr;
    }

    private void heapSort(int[] arr, int i, int length) {
        int curIndex = i;
        int curValue = arr[i];
        for (int j = 2*i+1; j < length; j=j*2) {
            if (j+1<length && arr[j+1]> arr[j]){
                j++;
            }
            if (arr[j] > curValue){
                arr[curIndex] = arr[j];
                curIndex = j;
            }else break;
        }
        arr[curIndex] = curValue;
    }

    @org.junit.Test
    public void Test() {
        int[] arr = {1,9,  3,  7, 5,11};
        int[] arr2 = SortTestUtil.generateRandomArray(50,0,100);
        int[] res = sort6(arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(",");
        }
    }
}
