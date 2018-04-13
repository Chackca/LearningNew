package 算法类.动态规划;

public class 最长公共子序列与子串 {

    public static void main(String[] args) {
        String first = new String("51649728");
        String second = new String("1649827");
        System.out.println(lcs(first,second));
        System.out.println(longestString(first,second));

    }


    //用c[i,j]表示Xi 和 Yj 的LCS的长度
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    //此处有不同
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);//此处不同
                }
            }
        }
        return c[len1][len2];
    }


    public static int longestString(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;     //记录最长公共子串长度
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    result = Math.max(c[i][j], result);//此处不同
                } else {
                    c[i][j] = 0;//此处不同
                }
            }
        }
        return result;
    }
}
