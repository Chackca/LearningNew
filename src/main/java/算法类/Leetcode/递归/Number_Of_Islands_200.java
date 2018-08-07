package 算法类.Leetcode.递归;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Number_Of_Islands_200 {

    private static int maxRow;
    private static int maxClo;
    private static int d[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//行数不变、列数减1......
    private static boolean[][] visited ;


    private static int numIslands(int[][] grid){
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
        int arr[][]= new int[][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int arr2[][]= new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        System.out.println(numIslands(arr));
        System.out.println(numIslands(arr2));
    }
}
