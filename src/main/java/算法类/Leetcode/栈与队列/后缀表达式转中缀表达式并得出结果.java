package 算法类.Leetcode.栈与队列;

import java.util.Stack;

/**
   Evaluate the value of an arithmetic expression in Reverse Polish Notation.
   Valid operators are+,-,*,/. Each operand may be an integer or another expression.
   Some examples:
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class 后缀表达式转中缀表达式并得出结果 {

    public static void main(String[] args) {
        String[] str1 = new String[5];
        str1[0]="2";
        str1[1]="1";
        str1[2]="+";
        str1[3]="3";
        str1[4]="*";
        System.out.println(evalRPN(str1));

        String[] str2 = new String[5];
        str2[0]="4";
        str2[1]="13";
        str2[2]="5";
        str2[3]="/";
        str2[4]="+";
        System.out.println(evalRPN(str2));
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0 ; i<tokens.length;i++){
            try {
                stack.push(Integer.parseInt(tokens[i]));//如果是数字直接进栈，否则.....
            }catch (Exception e){
                exec(stack,tokens[i]);
            }
        }
        return stack.pop();
    }

    private static void exec(Stack stack, String token) {
        int a = (int)stack.pop();
        int b = (int)stack.pop();

        switch (token){
            case "+": stack.push(b+a); break;
            case "-": stack.push(b-a); break;
            case "*": stack.push(b*a); break;
            case "/": stack.push(b/a); break;
            default:
                System.out.println("Something wrong");
                break;
        }
    }
}
