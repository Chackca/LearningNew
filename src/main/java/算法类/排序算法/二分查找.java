package 算法类.排序算法;

import org.junit.Test;
import 自制集合类.MyHashMap.Map;

/**
 * @Author Chackca
 * @Description :二分查找的优化思路   https://www.cnblogs.com/penghuwan/p/8021809.html#_label3
 * 1、插值查找算法
 * 将mid=left + (right-left)/2 的计算更改为 mid = left + ((target-min)/(max-target))*(right-left)
 * 即更换1/2系数
 * 2、斐波那契查找算法
 *
 *
 * @Date 2018/8/23 15:25
 **/
public class 二分查找 {

    //使用递归实现，时间O(log2 N)，空间O(log2N )
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){
        //递归要在开头做好判断
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        int middle = (low + high) / 2;          //初始中间位置
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }
    }

    //不使用递归实现：while循环，时间O(log2 N)，空间O(1)
    public static int commonBinarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;         //定义middle

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        ///非递归要用while循环
        while(low <= high){//注意这里有=号
            middle = (low + high) / 2;
            if(arr[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;//注意这里要减1
            }else if(arr[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;//注意这里要+1
            }else{
                return middle;
            }
        }

        return -1;      //最后仍然没有找到，则返回-1
    }

    /**
     * 优化版：插值查找
     */
    public static int InterpolationSearch (int [] a, int key) {
        int low = 0;
        int high = a.length-1;
        int mid;
        while(a[low]!=a[high]&&key>=a[low]&&key<=a[high]){ // 这个判断条件很重要！ 不能缺少
            mid = low + (high - low)*(key - a[low])/(a[high] - a[low]);
            if(key<a[mid]) {
                high = mid - 1;
            }
            else if(key>a[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        if(key == a[low]) return low; // 如果是 2,2,2,2,2这种全部重复元素，返回第一个2
        else return -1;
    }


    /**
     * @description: 创建最大值刚好>=待查找数组长度的裴波纳契数组
     * @param a: 待查找的数组
     */
    private static int[] makeFiboArray(int[] a){
        int N = a.length;
        int first = 1,sec = 1,third=2,fbLength = 2;
        int high = a[N-1];
        while (third<N) { // 使得裴波那契数不断递增，直到值刚好大于等于原数组长度为止
            third = first + sec; // 根据f(n) = f(n-1)+ f(n-2)计算
            first = sec;
            sec = third;
            fbLength++; // 计算最后得到的裴波那契数组的长度
        }

        int [] fb = new int[fbLength]; // 根据上面计算的长度创建一个空数组
        fb[0] = 1; // 第一和一二个数是迭代计算裴波那契数的基础
        fb[1] = 1;
        for(int i=2;i<fbLength;i++){
            fb[i] = fb[i-1] + fb[i-2]; // 将计算出的裴波那契数依次放入上面的空数组中
        }

        return fb;
    }
    /**
     * @description: 裴波那契查找
     */
    public static int FIBOSearch (int [] a, int key) {
        int low, high;
        int lastA;
        int [] fiboArray = makeFiboArray(a); // 创建最大值刚好>=待查找数组长度的裴波纳契数组
        int filledLength = fiboArray[fiboArray.length-1];
        int [] filledArray = new int[filledLength]; // 创建长度等于裴波那契数组最大值的填充数组

        for(int i=0;i<a.length;i++) {
            filledArray[i] = a[i]; // 将原待排序数组的元素都放入填充数组中
        }

        lastA = a[a.length-1]; // 原待排序数组的最后一个值
        for (int i=a.length;i<filledLength;i++) {
            filledArray[i] = lastA; // 如果填充数组还有空的元素，用原数组最后一个元素值填满
        }

        low = 0;
        high = a.length-1; // 取得原待排序数组的长度 （注意是原数组！）
        int mid;
        int k = fiboArray.length -1;
        while(low<=high) {
            mid = low + fiboArray[k-1]-1;
            if(key<filledArray[mid]) {
                high = mid-1; // 排除右半边的元素
                k= k-1;       // f(k-1)是左半边的长度
            }else if(key>filledArray[mid]) {
                low = mid+1;  // 排除左半边的元素
                k = k-2;      // f(k-2)是右半边的长度
            }else {
                if(mid>high){ // 说明取到了填充数组末尾的重复元素了
                    return high;
                }else {
                    return mid; // 说明没有取到填充数组末尾的重复元素
                }
            }
        }
        return -1;
    }


    //测试代码
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int key = 1;
        //int position = recursionBinarySearch(arr,key,0,arr.length - 1);
        int position = FIBOSearch(arr, key);
        if(position == -1){
            System.out.println("查找的是"+key+",序列中没有该数！");
        }else{
            System.out.println("查找的是"+key+",找到位置为："+position);
        }
    }
}
