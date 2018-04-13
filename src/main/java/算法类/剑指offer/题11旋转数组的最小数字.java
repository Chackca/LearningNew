package 算法类.剑指offer;

/*
 * 题目要求：
把一个数组最开始的若干个元素搬到末尾成为数组的旋转，
如1,2,3,4,5=>3,4,5,1,2；0,1,1,1,1=>1,1,1,0,1；
0,1,1,1,1=>1,0,1,1,1。求一个原本递增的数组旋转后的最小数字。
 */

public class 题11旋转数组的最小数字 {

	private static int min(int[] data) {
		if (data == null || data.length < 2) return -1;
		
		int start = 0;
		int end = data.length-1;
		int middle = 0;
		while (data[start]>=data[end]) {
			if (end-start ==1) {
				middle = end;break;
			}
			
			middle = (end + start)/2;
			
			/*
			 * 如果三个指向的数相同
			 */
			if (data[start]==data[middle] && data[end]==data[middle]) {
				return MinInOrder(data,start,end);
			}
			
			
			if(data[middle]>=data[start])
				start = middle;
			else if (data[middle]<=data[end]) 
				end = middle;
			
		}
		
		return data[middle];
	}
	
	
	private static int MinInOrder(int[] data, int start, int end) {
		for (int i = start+1; i <= end ; i++) 
			if (data[i]<data[i-1])return data[i];
		//若执行到这里，表明所有值都一样，则直接返回最后一个值
		return data[end];
	}


	public static void main(String[] args){
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data3 = {1,1,1,0,1};
        int[] data4 = {1,1,1,1,1};
        System.out.println(min(data1));
        System.out.println(min(data2));
        System.out.println(min(data3));
        System.out.println(min(data4));
    }
	
}
