package 算法类.其他题目;

import java.util.*;

public class 今日头条寻找前缀 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long m = Long.parseLong(sc.nextLine());
        long n = Long.parseLong(sc.nextLine());
        ArrayList<String> listOfM = new ArrayList();
        for (long i = 0 ; i < m ;i++){
            listOfM.add(new String(sc.nextLine()));
        }
        sc.nextLine();//处理分割行
        ArrayList<String> listOfN = new ArrayList();

        HashMap map = new HashMap();

        for (long i = 0 ; i < n ;i++){
            listOfN.add(new String(sc.nextLine()));
            map.put(i,listOfN.get(new Long(i).intValue()).charAt(0));
        }

        long[] resultArr = new long[new Long(n).intValue()];

        Set<Map.Entry> entrySet = map.entrySet();
        for (long i = 0 ; i < m ;i++){

            if (map.containsValue(listOfM.get(new Long(i).intValue()).charAt(0))){

            }
        }

    }

}
