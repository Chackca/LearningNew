package 算法类.其他题目;

import java.util.ArrayList;
import java.util.Scanner;
public class 网易9月8日买房 {

    private static class Pair<T,K>{
        private T key;
        private K value;
        Pair(T key,K value){
            this.key=key;
            this.value = value;
        }
        public T getKey() {
            return key;
        }

        public K getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            long t = in.nextLong();
            ArrayList<Pair<Long,Long>> list = new ArrayList();
            for (int i = 0; i < t; i++) {
                long n = in.nextLong();
                long k = in.nextLong();
                Pair pair = new Pair<Long,Long>(n,k);
                list.add(pair);
            }
            findResult(list);
        }
    }

    private static void findResult(ArrayList<Pair<Long,Long>> list) {
        for (int i = 0; i < list.size(); i++) {
             Pair<Long,Long> pair = list.get(i);
             long n = pair.getKey();
             long k = pair.getValue();
             long min = 0;
             long max = 0;
             if (k==n) {
                 System.out.println(min + " " + max);
                 continue;
             }
             for (long j = 0; j < n && k!=0 ; j++) {
                 if (j%2==0) {
                     k--;
                     if (k == 0) break;
                 }else if (j!=n-1){
                     max++;
                 }
             }
             System.out.println(min+" "+max);
        }
    }
}
