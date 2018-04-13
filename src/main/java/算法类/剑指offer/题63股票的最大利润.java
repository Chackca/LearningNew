package 算法类.剑指offer;

public class 题63股票的最大利润 {
	
	private static int maxDiff(int[] data) {
		if (data.length <2 ||data==null) {
			return -1;
		}
		
		int min = data[0];
		int maxDiff = data[1]-min;
		
		for (int i = 2; i < data.length; i++) {
			if (data[i-1]<min) {
				min = data[i-1];
			}
			int currentDiff = data[i-1] - min;
			if (currentDiff>maxDiff) {
				maxDiff = currentDiff;
			}
		}
		
		
		
		return maxDiff;
	}
	
	
	
	public static void main(String[] args){
	    int[] data1 = new int[]{9,11,8,5,7,12,16,14};
	    int[] data2 = new int[]{9,8,7,6,5,4,3,1};
	    System.out.println(maxDiff(data1)); //11
	    System.out.println(maxDiff(data2)); //-1
	}

}
