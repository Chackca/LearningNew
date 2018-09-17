package 算法类.Leetcode.递归;

/**
 * @Author Chackca
 * @Date 2018/9/8 21:37
 * @Description :
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 **/
public class 验证回文串125 {
    public boolean isPalindrome(String s) {
        int start=0;
        int end = s.length()-1;
        while(start<=end){
            char p = s.charAt(start);
            char l = s.charAt(end);
            if (!isChar(p)){
                start++;
                continue;
            }
            if (!isChar(l)){
                end--;
                continue;
            }
            if (Character.toLowerCase(p)!=Character.toLowerCase(l)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isChar(char c){
        if ((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z')){
            return true;
        }
        return false;
    }
}
