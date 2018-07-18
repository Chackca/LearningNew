package 算法类.Leetcode.栈;

import java.util.Stack;

/**
 * 逆波兰表达式求值，给定一个数组，表示一个逆波兰表达式。求其值
 * 如：【"2","1","+","3","*"】，表示(2+1)*3=9
 * 如：【"4","13","5","/","+"】，表示4+(13/5)=6
 */
public class Evaluate_Reverse_Polish_Notation_120 {

    private static int evaluateReversePolishNotation(String[] str) {
        if (str == null) return -1;
        int result = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (!s.equals("+")&&!s.equals("-")&&
                    !s.equals("/")&&!s.equals("*")){
                stack.push(s);
            }else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (s.equals("+")){
                    stack.push(String.valueOf(a+b));
                }else if (s.equals("-")){
                    stack.push(String.valueOf(a-b));
                }else if (s.equals("*")){
                    stack.push(String.valueOf(a*b));
                }else if (s.equals("/")){
                    stack.push(String.valueOf(a/b));
                }else return -1;
            }
        }
        while (!stack.isEmpty()){
            result+=Integer.parseInt(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"2","1","+","3","*"};
        System.out.println(evaluateReversePolishNotation(str));
        String[] str2 = {"4","13","5","/","+"};
        System.out.println(evaluateReversePolishNotation(str2));

    }


}
