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
        for (int i = 0; i < arr.length; i++) {
            int curMinIndex = i;
            int curMin = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<curMin) {
                    curMinIndex = j;
                    curMin = arr[j];
                }
            }
            SortTestUtil.swap(arr,i,curMinIndex);
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public int[] sort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int curIndex = i;
            int curValue = arr[i];
            while (i-1>=0 && arr[i-1]>curValue){
                arr[i] = arr[i-1];
                i--;
            }
           arr[i] = curValue;
            i = curIndex;
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
                int curValue = arr[i];
                int curIndex = i;
                while (curIndex-gap>=0 && arr[curIndex-gap]>curValue){
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
        int l = 0;
        int r = arr.length-1;
        System.out.println("快速排序");
        sort(arr,l,r);
        return arr;
    }

    private void sort(int[] arr, int l, int r) {
        if (r<l)
            return;
        int partition = partition(arr,l,r);
        sort(arr,l,partition-1);
        sort(arr,partition+1,r);
    }

    private int partition(int[] arr, int l, int r) {
        int t = arr[l];
        while(l<r){
            while (arr[r]>t){
                r--;
            }
            if (l<r && arr[r]<t){
                arr[l] = arr[r];
            }
            while(l<r&&arr[l]<t){
                l++;
            }
            if (l<r&&arr[l]>t){
                arr[r] = arr[l];
            }
        }
        arr[l] = t;
        return l;
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public int[] sort5(int[] arr){
        int l = 0;
        int r = arr.length-1;
        System.out.println("归并排序");
        int[] temp = new int[arr.length];
        merge(arr,l,r,temp);
        return arr;
    }

    private void merge(int[] arr, int l, int r,int[] temp) {
        if (l>=r)
            return;
        int middle = l + (r-l)/2;
        merge(arr,l,middle,temp);
        merge(arr,middle+1,r,temp);
        mergeTogether(arr,l,r,middle,temp);
    }

    private void mergeTogether(int[] arr, int l, int e, int middle,int[] temp) {
        int start = l;
        int r = middle+1;
        int tempIndex = 0;
        while (l<=middle && r<=e){
            if (arr[l]<=arr[r])
                temp[tempIndex++]=arr[l++];
            else temp[tempIndex++] = arr[r++];
        }
        while (l<=middle){
            temp[tempIndex++]=arr[l++];
        }
        while(r<=e){
            temp[tempIndex++] = arr[r++];
        }

        for (int i = 0; i < tempIndex; i++) {
            arr[i+start] = temp[i];
        }
    }


    /**
     * 桶排序
     * @param arr
     * @return
     */
    public int[] sort6(int[] arr){
        System.out.println("桶排序");
        for (int i = arr.length/2-1; i >= 0; i--) {
            buildHeap(arr,i,arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            SortTestUtil.swap(arr,0,arr.length-i-1);
            buildHeap(arr,0,arr.length-i-1);
        }
        return arr;
    }
    private void buildHeap(int[] arr, int i, int length) {
        int target = arr[i];
        for (int j = 2*i+1; j < length;j = 2*j+1) {
            if (j+1<length && arr[j+1]>arr[j]){
                j++;
            }
            if(arr[j]>target){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
        arr[i] = target;
    }

    @org.junit.Test
    public void Test() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int[] arr2 = SortTestUtil.generateRandomArray(50,0,100);
        int[] res = sort7(arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(",");
        }
    }
}
