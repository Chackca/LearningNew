package 算法类.其他题目;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class 字节跳动双生词8月25日 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int t = Integer.parseInt(in.nextLine());//代表多少组数据
            int[] arr = new int[t];
            ArrayList<ArrayList<String>> list = new ArrayList();
            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(in.nextLine());
                ArrayList innerList = new ArrayList();
                for (int j = 0; j < arr[i]; j++) {
                    innerList.add(in.nextLine());
                }
                list.add(innerList);
            }

            for (int i = 0; i < t; i++) {
                ArrayList<String> innerList = list.get(i);
                String str = innerList.get(0);
                boolean isShuangSheng = false;
                for (int j = 1; j < innerList.size(); j++) {
                    String temp = innerList.get(j);
                    isShuangSheng = check(str,temp);
                    if (isShuangSheng)
                        System.out.println("Yeah");
                }
                if (!isShuangSheng)
                    System.out.println("Sad");
            }
        }



    }
    /*@Test
    public void test(){
        System.out.println(check("helloworld","hdlrowolle"));
        System.out.println(check("helloworld","worldhello"));
        System.out.println(check("abcde","acbde"));
    }*/

    private static boolean check(String str1, String temp) {
        if (str1 == null || temp == null)
            return false;
        if (str1.length() != temp.length())
            return false;
        int length = str1.length();
        int border = length*2-1;
        String str2 = temp+temp;

        String str2Rever = new StringBuilder(str2).reverse().toString();

        for (int i = 0; i < border; i++) {
            boolean found = false;
            int str1Index = 0;
            if (i+length>border)
                break;
            for (int j = i; !found && length+i < border &&j < length+i; j++) {
                if (str2.charAt(j)!=str1.charAt(str1Index))
                    continue;
                else{
                    if (str1Index == length-1)
                        found = true;
                    str1Index++;
                }
            }
            if (found)
                return true;
        }
        for (int i = 0; i < border; i++) {
            boolean found = false;
            int str1Index = 0;
            if (i+length>border)
                break;
            for (int j = i; !found && j<border; j++) {
                if (str2Rever.charAt(j)!=str1.charAt(str1Index))
                    continue;
                else{
                    if (str1Index == length-1)
                        found = true;
                    str1Index++;
                }
            }
            if (found)
                return true;
        }
        return false;
    }
}
/*
3
2
helloworld
hdlrowolle
2
helloworld
worldhello
2
abcde
acbde

 */