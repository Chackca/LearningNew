package 算法类.剑指offer;
/*
 * 题目要求：
	在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
	从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，
	求拿到礼物的最大价值。例如，对于如下棋盘
	
	1    10   3    8
	12   2    9    6
	5    7    4    11
	3    7    16   5
	礼物的最大价值为1+12+5+7+7+16+5=53。
	
	解题思路：
	思路1：动态规划
	申请一个与原矩阵行列数一样的二维数组dp[][]，初始化dp[0][i] = data[0][i]；
	然后依次更新dp的每一行即可。由于第m行的值与第m-1行和第m行有关，
	因此可以对dp进行简化，仅用两行的dp，即dp[2][]即可完成状态的记录与更新。
	
	思路2：广度优先遍历
	这个棋盘其实可以看成一个有向图，起点为左上角，终点为右下角，每一点仅仅指向右侧和下侧。
	因此我们可以从左上角开始进行广度优先遍历。此外，
	遍历过程中可以进行剪枝，最终移动到右下角时会仅剩下一个枝，该路径所经的点的数值之和即为所求。

 */
public class 题47礼物的最大价值 {
	
	//用一个二维数组记录到达data【i】【j】所能达到的最大值
	private static int getMaxVaule(int[][] data) {
		if (data.length==0||data==null) {
			return 0;
		}
		//这里可以用一维数组长度为data.length来记录
		int[][] maxValues = new int[data.length][data[0].length];
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[0].length; col++) {
				if (row>=1&&col>=1) {
					maxValues[row][col] = data[row][col]+max(maxValues[row-1][col],maxValues[row][col-1]);	
				}else if (row<1&&col>=1) {
					maxValues[row][col] = data[row][col]+maxValues[row][col-1];	
				}else if (col<1&&row>=1) {
					maxValues[row][col] = data[row][col]+maxValues[row-1][col];	
				}else if (col<1&&row<1) {
					maxValues[row][col] = data[row][col];	
				}
			}
		}
		return maxValues[data.length-1][data[0].length-1];
	}
	private static int max(int i, int j) {
		return (i-j)>0?i:j;
	}

	//用一个一维数组
	private static int getMaxVaule2(int[][] data) {
		if (data.length==0||data==null) {
			return 0;
		}
		//这里可以用一维数组长度为data.length来记录
		int[] maxValues = new int[data.length];
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[0].length; col++) {
				if (row>=1&&col>=1) {
					maxValues[col] = data[row][col]+max(maxValues[col],maxValues[col-1]);	
				}else if (row<1&&col>=1) {
					maxValues[col] = data[row][col]+maxValues[col-1];	
				}else if (col<1&&row>=1) {
					maxValues[col] = data[row][col]+maxValues[col];	
				}else if (col<1&&row<1) {
					maxValues[col] = data[row][col];	
				}
			}
		}
		return maxValues[data.length-1];
	}

	
	public static void main(String[] args){
        int[][] data = {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
        System.out.println(getMaxVaule(data));//53
        System.out.println(getMaxVaule2(data));//53
    }

	
}
