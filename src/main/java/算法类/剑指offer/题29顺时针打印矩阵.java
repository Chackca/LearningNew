package 算法类.剑指offer;

public class 题29顺时针打印矩阵 {
	
	public static void PrintMatrixClockwisely(int[][] numbers) {
		if (numbers == null) {
			return;
		}
		int rows = numbers.length;
		int cols = numbers[0].length;
		
		int start = 0;
		while (rows>start*2&&cols>start*2) {
			PrintMatrixInCircle(numbers,rows,cols,start);
			start++;
		}
	}
	
	
    private static void PrintMatrixInCircle(int[][] numbers, int rows, int cols, int start) {
    	int endX = cols - start-1;
    	int endY = rows - start-1;
    	//从左到右打印一行
    	for (int i = start; i <= endX; i++) {
			System.out.print(numbers[start][i]);
		}
    	//从上到下打印一列
    	if (endY > start) {
    		for (int i = start+1; i <= endY; i++) {
    			System.out.print(numbers[i][endX]);
    		}
		}
    	//从右到左打印一行
    	if (endY > start && endX > start ) {
    		for (int i = endX-1; i >= start; i--) {
    			System.out.print(numbers[endY][i]);
    		}
		}
    	//从下到上打印一行
    	if (endY > start+1 && endX > start) {
    		for (int i = endY-1; i >= start+1; i--) {
    			System.out.print(numbers[i][start]);
    		}
		}
    	
	}


	public static void main(String[] args){
        int[][] data1={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };
        int[][] data2={
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6},
        };
        int[][] data3={
                {1,2,3},
                {10,11,4},
                {9,12,5},
                {8,7,6},
        };
        int[][] data4={
                {1,2,3},
                {8,9,4},
                {7,6,5},
        };
        PrintMatrixClockwisely(data1);
        System.out.println();
        PrintMatrixClockwisely(data2);
        System.out.println();
        PrintMatrixClockwisely(data3);
        System.out.println();
        PrintMatrixClockwisely(data4);
    }


}
