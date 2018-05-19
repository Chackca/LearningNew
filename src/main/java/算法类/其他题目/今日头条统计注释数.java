package 算法类.其他题目;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 统计输入的注释有几个，不包括引号内的
 */

public class 今日头条统计注释数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strList = new ArrayList<>();
        //StringBuilder SB = new StringBuilder();
        int lineCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            strList.add(lineCount,new String(str));
            //SB.append(str);
            list.add(str.length());
            //SB.append("\n");
            lineCount++;
        }
        int result = 0;
        boolean hasXing = false;
        boolean yinhao = false;
        int yinhaoCount = 0;

        for (int i = 0 ; i < lineCount ; i++){
            for (int j = 0; j < list.get(i); j++) {
                if (!hasXing&&!yinhao) {
                    if (strList.get(i).charAt(j) == '/') {
                        if (j + 1 < list.get(i) && strList.get(i).charAt(j + 1) == '/') {
                            result++;
                            break;//跳出第二层的for循环
                        } else if (j + 1 < list.get(i) && strList.get(i).charAt(j + 1) == '*') {
                            j++;
                            hasXing=true;
                        }
                    }if (strList.get(i).charAt(j) == '"') {
                        if (yinhaoCount==0){
                            yinhaoCount++;
                            yinhao= true;
                        }else {
                            yinhao =false;
                            yinhaoCount = 0;
                        }
                    }
                }else {
                    if (strList.get(i).charAt(j) == '*') {
                        if (j + 1 < list.get(i) && strList.get(i).charAt(j + 1) == '/'){
                            hasXing = false;
                            j++;
                            result++;
                        }
                    }else if (strList.get(i).charAt(j) == '"') {
                        if (yinhaoCount==0){
                            yinhaoCount++;
                            yinhao= true;
                        }else {
                            yinhao =false;
                            yinhaoCount = 0;
                        }
                    }
                }
            }

        }

        System.out.println(result);
    }

}
