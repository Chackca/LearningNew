package 算法类.Leetcode.动态规划;

import java.util.HashSet;
import java.util.Set;

/***
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     For example, given
     s ="leetcode",
     dict =["leet", "code"].
     Return true because"leetcode"can be segmented as"leet code".
 */
public class word_break {

    public static class Solution {
        /*
           * 方法：用一个f(i)来存储目标字符串在[0,i]的范围的字符串是否可以在dict中做到分词，找得到的话就设置为true
           *    由于一个词可能由不止2个分词组成，所以最好是从0开始找，找到就设置为true，后面的查找可以直接复用前面的f(i)
           * 状态转移方程：
           * f(i)=arrays[i] 表示s[0,i]是否可以分词
           * f(i) = f(j) && f(j+1,i); 0 <= j < i; f(i)可分代表s[0,j]可分且[j+1,i]可分
           * f(0):可分 true
           * f(1):若dict中包含s[0,1]这个词，则true，否则false
           * f(2):若dict中包含s[0,2]这个词，则true
           *        否则若dict中包含s[0,1]与s[1,2]这两个词，则true，否则false
           */
        public static boolean wordBreak(String s, Set<String> dict){
            int len = s.length();
            boolean[] arrays = new boolean[len+1];
            arrays[0] = true; //从字符串中取0个元素一定可以在dict中找到
            for (int i = 1; i <= len; ++i){
                for (int j = 0; j < i; ++j){
                    if (arrays[j] && dict.contains(s.substring(j, i))){
                        arrays[i] = true;
                        break;
                    }
                }
            }
            return arrays[len];
        }
    }

    public static void main(String[] args) {
        String str = new String("leetcode");
        Set<String> map = new HashSet(){};
        map.add("leet");
        map.add("code");
        System.out.println(Solution.wordBreak(str,map));
    }
}
