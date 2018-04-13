package 算法类.其他题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 今日头条6周年活动小彩蛋 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
  
        ArrayList<Long> list = new ArrayList<Long>();
        String s;
        for (int i = 0; i < n; i++) {
                s = sc.nextLine();
                Long res = getRes(s);
                list.add(res);
        }
        System.out.println(list.get(0));
  
        printRes(list);
    }
  
    private static Long getRes(String s) {
        long cur = 0l;
        long sum = 0l;
        long symbol = 1;
  
        for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isDigital(c)) {
                        cur = cur * 10 + c - '0';
                } else if (c == '+') {
                        sum += symbol * cur;
                        cur = 0;
                        symbol = 1;
                } else if (c == '-') {
                        sum += symbol * cur;
                        cur = 0;
                        symbol = -1;
  
                } else {
                        symbol *= cur;
                        cur = 0;
                }
        }
        return sum + cur * symbol;
  
    }
  
    private static boolean isDigital(char c) {
        if (c == '+' || c == '-' || c == '*')
                return false;
        return true;
  
    }
  
    public static void printRes(List<Long> list) {
        String[][] charNum = {{"66666", "....6", "66666", "66666", "6...6", "66666", "66666", "66666", "66666", "66666"},
                              {"6...6", "....6", "....6", "....6", "6...6", "6....", "6....", "....6", "6...6", "6...6"},
                              {"6...6", "....6", "66666", "66666", "66666", "66666", "66666", "....6", "66666", "66666"},
                              {"6...6", "....6", "6....", "....6", "....6", "....6", "6...6", "....6", "6...6", "....6"},
                              {"66666", "....6", "66666", "66666", "....6", "66666", "66666", "....6", "66666", "66666"}};
        //循环5次，代表5行
        for (int i = 0; i < 5; i++) {
                //循环含有的结果数
                for (int j = 0; j < list.size(); j++) {
                        //将数字转换为字符串
                        String num = list.get(j) + "";
                        //开始遍历字符串
                        for (int k = 0; k < num.length(); k++) {
                                //将字符串转换为数字，代表二维数组的下标
                                int index = num.charAt(k) - '0';
                                System.out.print(charNum[i][index]);
                                //如果当前到达了最后一个数 && 当前到达了字符串的末尾
                                if (k == num.length() - 1)
                                if (j == list.size() - 1 && k == num.length() - 1)
                                        continue;
                                System.out.print("..");
                        }
                }
                System.out.println();
        }
    }









    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>(n);
        int result = 0;
        for (int i = 0; i <n;i++){
            list.add(i,sc.nextLine());

            StringBuilder str = new StringBuilder(list.get(i));

            for (int j = 0;j<str.length();j++){

                if ("*".equals(str.substring(j,j+1))){
                    int start = j-1;
                    int end = j+1;
                    while (start>0&&!str.substring(start,start+1).equals("+")&&
                            !str.substring(start,start+1).equals("-")&&
                            !str.substring(start,start+1).equals("*")){
                        start--;
                    }
                    while (end<str.length()&&!str.substring(end,end+1).equals("+")&&
                            !str.substring(end,end+1).equals("-")&&
                            !str.substring(end,end+1).equals("*")){
                        end++;
                    }
                    int tempResult = Integer.parseInt(str.substring(start,j))
                            * Integer.parseInt(str.substring(j+1,end));
                    StringBuilder str1 = new StringBuilder(str.substring(0,start+1)+tempResult+str.substring(end,str.length()));//注意
                    str = str1;

                    //String s=Integer.toString(tempResult);
                    //int t=s.length();
                    j = start-1;
                }

            }
            for (int j = 0;j<str.length();j++){
                //result = str.substring();
            }
        }





    }*/
}
