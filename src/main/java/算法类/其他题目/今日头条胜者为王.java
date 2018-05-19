package 算法类.其他题目;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class 今日头条胜者为王 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());//表示有几行
        for (int i = 0 ; i < N; i++) {
            long n = sc.nextLong();//表示入围的人
            int m = sc.nextInt();//表示黑板上有几个数字
            LinkedList<Long> list= new LinkedList();
            for (long j = 0 ; j < n ; j++) {
                list.add(j);
            }
            int[] arr = new int[m];
            for (int j = 0 ; j < m ; j++) {
                arr[j]=sc.nextInt()-1;

            }
            int k = 0;
            while (list.size()!=1) {
                playing(list, arr[k++]);
                if (k==m) k =0;
            }
            System.out.println(list.get(0));
        }

    }

    private static void playing(LinkedList<Long> list, int Ax) {
        if (Ax>=list.size())
            Ax = Ax%list.size()+1;
        list.remove(Ax);
    }
}
