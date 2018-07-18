package 算法类.Leetcode.栈;

import java.util.Stack;

/**
 * 给定一个字符串，只包含(,[,{,),],}，判定字符串中的括号匹配是否合法
 */
public class Valid {

    private static boolean Valid(String str){
        if (str == null)return false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char aChar = str.charAt(i);
            if (aChar == '{'||aChar == '('||aChar == '['){
                stack.push(aChar);
                continue;
            }else if (stack.size()!=0){
                char match = stack.peek();
                if (match == '(' && aChar == ')'){
                    stack.pop();
                }else if (match == '[' && aChar == ']'){
                    stack.pop();
                }else if (match == '{' && aChar == '}'){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if (stack.size()!=0) return false;
        return true;
    }

    public static void main(String[] args) {
        String str = new String("{({[]})}");
        System.out.println(Valid(str));
    }
}
