package 算法类.其他题目;

import java.util.Scanner;

/**
 * 题目描述
 用程序写一个对称加密算法，输入数字仅限于（1，2，3，4，5）五个数字，然后按下面规则进行加密码，1变成2，2变成4，3变成1，4变成5，5变成3，请编写最简单的程序，不能使用if语句。
 输入描述:
 在范围1，2，3，4，5内的任意个数字,用逗号分开
 输出描述:
 转换之后的数字,按顺序输出,用逗号分开
 示例1
 输入
 1,4,3,2,1,5
 输出
 2,5,1,4,2,3
 */
public class 虎牙加密算法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] str = sc.nextLine().split(",");
            StringBuilder SB = new StringBuilder();
            for (int i = 0; i < str.length ; i++){
                switch (str[i]){
                    case "1": str[i] = "2"; break;
                    case "2": str[i] = "4"; break;
                    case "3": str[i] = "1"; break;
                    case "4": str[i] = "5"; break;
                    case "5": str[i] = "3"; break;
                    default:  break;
                }
                SB.append(str[i]+",");
            }
            System.out.println(SB.toString().substring(0,SB.toString().length()-1));
        }
    }
}
