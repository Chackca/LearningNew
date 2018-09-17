package 算法类.其他题目;

import java.util.Scanner;

public class 字节跳动9月9日组织优化 {
    private static int maxRow;
    private static int maxClo;
    private static int d[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    private static boolean[][] visited ;

    private static int numOfTeams(int[][] grid){
        if (grid == null){
            return -1;
        }
        maxClo = grid.length;
        if (maxClo>0) {
            maxRow = grid[0].length;
        }
        int res = 0;
        visited = new boolean[maxClo][maxRow];
        for (int i = 0; i < maxClo; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (grid[i][j]==1 && !visited[i][j]){
                    res++;
                    dfs(grid,j,i);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int curRow, int curClo) {
        visited[curClo][curRow]= true;
        for (int i = 0; i < 4; i++) {
            int newRow = curRow + d[i][0];
            int newClo = curClo + d[i][1];
            if ( newRow >= 0 && newRow < maxRow && newClo >= 0 && newClo < maxClo
                    && !visited[newClo][newRow]
                    && grid[newClo][newRow]==1){
                dfs(grid,newRow,newClo);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int clo = 0; clo < n; clo++) {
                    arr[row][clo] = in.nextInt();
                }
            }
            System.out.println(numOfTeams(arr));
        }
    }
}
