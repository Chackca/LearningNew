package 算法类.剑指offer;
/*
 * 	面试题12：矩阵中的路径

	题目要求：
	设计一个函数，用来判断一个矩阵中是否存在一条包含某字符串的路径。
	（1）起点随意；（2）路径的移动只能是上下左右；
	（3）访问过的位置不能再访问。以下图矩阵为例，包含“bfce”，但是不包含“abfb”。
 */
public class 题12矩阵中的路径 {
	
	private static boolean hasPath(char[][] data, String str) {
		if(data==null || data.length==0 || str==null || str.trim().length()==0)
			return false;
		int rows = data.length;
		int cols = data[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		int pathLength = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				//参数：原数组、boolean型数组、要找的路径，当前要找的路径的第几位，总行，总列，当前行，当前列
				if (hasPathCore(data,visited,str,pathLength,rows,cols,row,col)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private static boolean hasPathCore(char[][] data, boolean[][] visited, 
			String str, int pathLength, int rows,int cols, int row, int col) {
		if (pathLength>=str.length()) return true;
		boolean hasPath = false;
		
		if ( row>=0 && col>=0 && row<rows && col<cols && visited[row][col]!=true 
				&& data[row][col] == str.charAt(pathLength)) {
			pathLength++;
			visited[row][col]=true;
			
			hasPath=hasPathCore(data,visited,str,pathLength,rows,cols,row+1,col)||
					hasPathCore(data,visited,str,pathLength,rows,cols,row-1,col)||
					hasPathCore(data,visited,str,pathLength,rows,cols,row,col+1)||
					hasPathCore(data,visited,str,pathLength,rows,cols,row,col-1);
			
			//表明不存在此路径
			if (!hasPath) {
				pathLength--;
				visited[row][col]=false;
			}
		}
		
		return hasPath;
	}


	public static void main(String[] args){
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(hasPath(data,"bfce")); //true
        System.out.println(hasPath(data,"abfb")); //false,访问过的位置不能再访问
    }

}
