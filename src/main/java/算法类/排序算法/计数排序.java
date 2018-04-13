package 算法类.排序算法;

import org.junit.Test;

public class 计数排序 implements Sort {

	@Override
	public void executeSort(int[] data) {
		CountSort(data);
	}
	
	//计数排序：适用于数据分布比较集中的数组
	//需要知道数组中的最大与最小值，然后创建一个大小为max-min的新数组，再遍历原数组
	//遍历到每个值则将新数组的那个位置+1
	//此案例需要根据具体要求来，下面代码的鲁棒性并不好
	private static void CountSort(int[] data){
		if (data==null) return;
		int min = data[0];
		int max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i]>max) {
				max = data[i];
			}else if (data[i]<min) {
				min = data[i];
			}
		}
		//以上步骤只是为了找出最大最小值以便于创建临时数组，非计数排序必须，这里只是因为输入的数组没有规定数组大小范围
		int[] bucket = new int[max-min+1];
		for (int i = 0; i < data.length; i++) {
			bucket[data[i]-min]++;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i]!=0) {
				for (int j = 0; j < bucket[i]; j++) {
					System.out.print(i+min);
					System.out.print(" ");
				}
			}
		}
	}
	//计数排序测试
	@Test
	private void countSortTest(){
        int[] data = {5,4,3,1,2,6,10,7,7,4,12};
        System.out.println("数组计数排序：\t");
        CountSort(data);
        
    }

}
