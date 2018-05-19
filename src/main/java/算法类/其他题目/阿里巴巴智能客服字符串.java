package 算法类.其他题目;

import java.util.Scanner;

/**
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
            StringBuilder SB = new StringBuilder();
            for (int i = 0; i < length ; i++){
                int temp = i;
                char cha = str.charAt(i);
                if (cha>='0' && cha<='9'){
                    SB.append(cha);
                    continue;
                }
                boolean inFor = false;
                for (int j = SB.length()-1 ; j>=0 ; j--){
                    inFor = true;
                    if (SB.charAt(j) == cha){
                        while ( j<=SB.length()-1 && temp<length && SB.charAt(j) == str.charAt(temp) ){
                            temp++;
                            j++;
                        }
                        if (j<=SB.length()-1 && temp == length ){
                            inFor = false;
                            break;
                        }
                        if (j<=SB.length()-1 && temp<length && SB.charAt(j) != str.charAt(temp)){
                            inFor = false;
                            break;
                        }else {
                            if (temp -1 == i) {
                                inFor = false;
                            }
                            i = temp-1;
                            break;
                        }
                    }
                    if (j==0){
                        SB.append(cha);
                    }
                }
                if (!inFor){
                    SB.append(cha);
                }

            }
            System.out.println(SB.toString());
        }


























        /*while (sc.hasNext()){
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
        }*/
    }
}
