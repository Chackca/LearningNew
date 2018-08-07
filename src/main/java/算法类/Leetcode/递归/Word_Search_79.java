package 算法类.Leetcode.递归;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class Word_Search_79 {

    private static int maxRow;
    private static int maxClo;
    private static int d[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//行数不变、列数减1......


    private static boolean searchWord(char[][] arr,String word,int index , int curRow,int curClo,boolean[][] visited){
        if (index == word.length()-1){
            return arr[curClo][curRow] == word.charAt(index);
        }
        if (arr[curClo][curRow] == word.charAt(index)) {
            visited[curClo][curRow] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + d[i][0];
                int newClo = curClo + d[i][1];
                if (newRow<maxRow && newRow>=0 && newClo<maxClo && newClo >=0 && !visited[newClo][newRow]){
                    if (searchWord(arr,word,index+1,newRow,newClo, visited))
                        return true;
                }
            }
            visited[curClo][curRow] = false;
        }
        return false;
    }

    private static boolean exist(char[][] arr ,String word ){
        if (arr == null || word.length() == 0){
            return false;
        }
        maxClo = arr.length;
        if (maxClo>0) {
            maxRow = arr[0].length;
        }
        boolean[][] visited = new boolean[maxClo][maxRow];
        for (int i = 0; i < maxClo; i++)
            for (int j = 0; j < maxRow; j++)
                if (searchWord(arr,word,0,j,i,visited))
                    return true;

        return false;
    }


    public static void main(String[] args) {
        char arr[][]= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(arr,"SEE"));
    }

}
