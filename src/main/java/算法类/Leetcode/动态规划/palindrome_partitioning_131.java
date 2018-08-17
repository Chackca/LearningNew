package 算法类.Leetcode.动态规划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class palindrome_partitioning_131 {

    public static List<List<String>> partition(String s) {
        if (s == null) return null;
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> cur = new LinkedList();
        dfs(s,cur,res);
        return res;
    }

    private static boolean isPalindrome(String temp) {
        return temp.equals(new StringBuilder(temp).reverse().toString());
    }

    private static void dfs(String s, LinkedList<String> cur, List<List<String>> res) {
        if (s.equals("")){
            res.add((List<String>) cur.clone());
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0,i);
            if (isPalindrome(temp)){
                cur.addLast(temp);
                dfs(s.substring(i,s.length()),cur,res);
                cur.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(partition(str));
    }

}
