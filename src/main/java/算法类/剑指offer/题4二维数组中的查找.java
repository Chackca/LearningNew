package 算法类.剑指offer;

/**
 * 
 * 二维数组，从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有这个数
 */
public class 题4二维数组中的查找 {
	
	private static boolean findInPartiallySortedMatrix(int[][] data, int target) {
		if(data==null ||data.length==0 || data[0].length==0)
	         return false;
		
		int rows = data.length-1;
		int row = 0;
		int col = data[0].length-1;
		
		//int cur = data[0][col];
		
		while (row<=rows&&col>=0) {
			if (data[row][col]==target) {
				return true;
			}
			if (data[row][col]>target) {
				col--;
			}else if (data[row][col]<target) {
				row++;
			}		
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        System.out.println(findInPartiallySortedMatrix(data, 10));
        System.out.println(findInPartiallySortedMatrix(data, 5));
    }
	
}
