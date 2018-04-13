package 算法类.剑指offer;

public class 题571和为s的数字 {
	
	private static int[] findNumbersWithSum(int[] data, int target) {
		
		if (data == null || target<=0) {
			return null;
		}
		
		int[] result = new int[2];
		
		int start = 0;
		int end = data.length-1;
		
		while (data[start]+data[end]!=target) {
			if (data[start]+data[end]<target) {
				start++;
			}else if (data[start]+data[end]>target) {
				end--;
			}
			if (start == end) {
				return null;
			}
		}
		result[0]=data[start];
		result[1]=data[end];
		
		return result;
	}
	
	
	
	public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        int[] result = findNumbersWithSum(data,15);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }


}
