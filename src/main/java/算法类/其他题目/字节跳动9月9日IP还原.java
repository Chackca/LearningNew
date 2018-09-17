package 算法类.其他题目;

import java.util.Scanner;

public class 字节跳动9月9日IP还原 {
    private static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            res = 0;
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            solution(sb,0,0);
            System.out.println(res);
        }
    }

    private static void solution(StringBuilder sb,int index,int currentIP) {
        if (index>=sb.length()){
            return;
        }
        if (currentIP == 3){
            String temp = sb.substring(index+0,sb.length());
            int k = Integer.parseInt(temp);
            if (k<=255)
                res++;
            return;
        }

        for (int i = 1; i <= 3 && index+i<sb.length(); i++) {
             String temp = sb.substring(index+0,index+i);
             int k = Integer.parseInt(temp);
             if (k<=255){
                 solution(sb,index+i,currentIP+1);
             }else{
                break;
             }
        }
    }
}
