package 算法类.剑指offer;

import java.util.Scanner;

/**
 * 未完成：
 * 要求：
 * 1、去除重复字符串
 * 2、重复的字符只有一个则不用理会
 * 3、数字重复不要管
 * 输入：我已经告诉你了我要退货我要退货你阿里旺旺怎么就不知道不知道呢？我要打100投诉你
 * 输出：我已经告诉你了我要退货你阿里旺旺怎么就不知道呢？我要打100投诉你
 */
public class 阿里巴巴智能客服字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i<length;i++){
                if ('0'<=str.charAt(i) && str.charAt(i)<='9'){
                    sb.append(str.charAt(i));
                    continue;
                }
                int ii = i;

                for (int j = sb.length()-1;j>=0;j--){
                    int temp = j;
                    if (str.charAt(i) == sb.charAt(j)){
                        //boolean Inwhile = false;
                        while (i<str.length() && j<sb.length() && (str.charAt(i)==sb.charAt(j))){
                            i++;
                            j++;
                            //Inwhile = true;
                        }
                        if (j != ii || temp == j-1){
                            i = ii;
                            ii++;//用于使外面的判断失效
                            sb.append(str.charAt(i));
                        }
                        //if (Inwhile) i--;
                        break;//跳出此for循环
                    }
                }
                if (ii == i) {
                    sb.append(str.charAt(i));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
