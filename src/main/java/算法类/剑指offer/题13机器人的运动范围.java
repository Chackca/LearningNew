package 算法类.剑指offer;
/*
 * 	
 * 面试题13：机器人的运动范围

	题目要求：
	地上有一个m行n列的方格，一个机器人从坐标(0,0)的各自开始移动，它每次可以向上下左右移动一格，但不能进入横纵坐标数位之和大于k的格子。
	例如，当k等于18时，机器人能进入(35,37)，因为3+5+3+7=18；但却不能进入(35,38)，因为3+5+3+8=19>18。
	请问该机器人能够到达多少个格子。

 */
public class 题13机器人的运动范围 {
	
	private static int movingCount(int threshold, int rows, int cols) {
		if (threshold<=0 ||rows<=0 ||cols<=0) return -1;
		boolean[][] visited = new boolean[rows][cols];
		int count = movingCountCore(threshold,rows,cols,0,0,visited);
		
		return count;
	}
	
	private static int movingCountCore(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
		
		int count = 0;
		
		if (curRow >= 0 && curCol >=0 &&curRow<rows && curCol<cols && !visited[curRow][curCol]
				&& threshold>=getDigitNum(curRow)+getDigitNum(curCol)) {
			visited[curRow][curCol] = true;
			count =  movingCountCore(threshold,rows,cols,curRow+1,curCol,visited) 
					+ movingCountCore(threshold,rows,cols,curRow-1,curCol,visited)
					+ movingCountCore(threshold,rows,cols,curRow,curCol+1,visited)
					+ movingCountCore(threshold,rows,cols,curRow,curCol-1,visited) 
					+ 1;
		}
		
		return count;
	}

	/*
	 * 该函数用于获取一个数的位数和
	 */
	private static int getDigitNum(int num){
		int result = 0;
		while (num>0) {
			result += num%10;//将个位数加起来
			num /= 10;//将个位数去掉
		}
		return result;
	}
	
	
	public static void main(String[] args){
		//参数：最大步数，m行，n列
        System.out.println(movingCount(0,3,4)); //1
        System.out.println(movingCount(1,3,4)); //3
        System.out.println(movingCount(9,2,20)); //36
    }

	
}
