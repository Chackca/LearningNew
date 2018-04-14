package 算法类.排序算法;

import java.util.ArrayList;
import java.util.Collections;


public class 桶排序  implements Sort {

	@Override
	public void executeSort(int[] data) {
		bucketSort(data);
	}
	
	
	/* 桶排序适用于数组里最大值与最小值相差较大，但是数字分布均匀的数组
	 * 1.找出数组里面的最大值max与最小值min，创建一个长度等于（原数组长度+1）的桶数组
	 * 2.执行 (max - min) / arr.length+1得到每个桶存储的区间范围
	 * 3.遍历原数组将数字存储到桶数组的合适位置
	 * 4.内部排序每个桶数组
	 * 5.依次遍历所有桶数组，将他们的值依次取出得出排序后的最终数组
	 */
	
	
	public static void bucketSort(int[] arr){

		//新建一个大小为原数组长度的数组
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList(arr.length);

	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;

	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
			bucketArr.add(new ArrayList());
	    }

	    //每个桶的区间大小
	    int bucketNum = (max - min) / arr.length+1;

	    //将每个元素放入桶
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / bucketNum ;
	        bucketArr.get(num).add(arr[i]);
	    }
	    
	    //对每个桶进行排序
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));
	    }
	    
	    System.out.println(bucketArr.toString());
	    
	}

	
	
	
	//桶排序测试
	public static void main(String[] args) {
	    int[] data = {1,10,50,40,30,500,420,280,350,250,200,120};
        System.out.println("数组桶排序：\t");
        bucketSort(data);
        
        int[] data1 = {1,9,999,555,5555};
        System.out.println("数组桶排序：\t");
        bucketSort(data1);
        
        int[] data2 = {1,1,1,2,2,1,5,4};
        System.out.println("数组桶排序：\t");
        bucketSort(data2);
        
        int[] data3 = {0,0,0,1,1,1,11,1,1};
        System.out.println("数组桶排序：\t");
        bucketSort(data3);
	}
}
